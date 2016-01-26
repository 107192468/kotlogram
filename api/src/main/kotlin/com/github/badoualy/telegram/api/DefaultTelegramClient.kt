package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.ApiCallback
import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException

internal class DefaultTelegramClient internal constructor(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                                          val preferredDataCenter: DataCenter) : TelegramApiWrapper(), TelegramClient, ApiCallback {

    var mtProtoHandler: MTProtoHandler? = null
    var authKey: AuthKey? = null
    var dataCenter: DataCenter? = null

    private var generateAuthKey: Boolean

    private val TAG = "TelegramClient"

    init {
        authKey = apiStorage.loadAuthKey()
        dataCenter = apiStorage.loadDc()
        generateAuthKey = authKey == null

        if (dataCenter == null) {
            if (!generateAuthKey) {
                apiStorage.deleteAuthKey()
                throw RuntimeException("Found an authorization key in storage, but the DC configuration was not found, deleting authorization key")
            }
            Log.d(TAG, "No data center found in storage, using preferred ${preferredDataCenter.toString()}")
            dataCenter = preferredDataCenter
        }

        // No need to check DC if we have an authKey in storage
        init(checkNearestDc = generateAuthKey)
    }

    private fun init(checkNearestDc: Boolean = true) {
        mtProtoHandler = if (generateAuthKey) MTProtoHandler(generateAuthKey(), this) else MTProtoHandler(dataCenter!!, authKey!!, apiStorage.loadServerSalt(), this)
        mtProtoHandler!!.startWatchdog()

        try {
            // Call to initConnection to setup information about this app for the user to see in "active sessions"
            // Also will indicate to Telegram which layer to use through InvokeWithLayer
            val nearestDc = initConnection(mtProtoHandler!!, TLRequestHelpGetNearestDc())
            if (checkNearestDc)
                ensureNearestDc(nearestDc)
        } catch(e: Exception) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.error.errorCode == -404)
                throw RuntimeException("Your authorization key seems to be invalid (error " + e.error.errorCode + ")")
            throw RuntimeException("An unknown error has occurred", e)
        }
    }

    private fun generateAuthKey(): AuthResult {
        val authResult = AuthKeyCreation.createAuthKey(dataCenter!!) ?: throw RuntimeException("Couldn't generate authorization key")
        authKey = authResult.authKey
        apiStorage.saveAuthKey(authKey!!)
        apiStorage.saveDc(dataCenter!!)
        return authResult
    }

    private fun <T : TLObject> initConnection(mtProtoHandler: MTProtoHandler, method: TLMethod<T>) = mtProtoHandler
            .executeMethod(TLRequestInvokeWithLayer(Kotlogram.API_LAYER, TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, method)))
            .toBlocking().first()

    @Throws(IOException::class)
    private fun ensureNearestDc(nearestDc: TLNearestDc) {
        if (nearestDc.thisDc != nearestDc.nearestDc) {
            if (!generateAuthKey) {
                // Key was provided, yet selected DC is not the nearest
                // TODO: Should handle authKey migration via auth.exportAuthorization
                mtProtoHandler?.close()
                throw RuntimeException("You tried to connect to an incorrect data center (DC${nearestDc.thisDc}) with an authorization key in storage, please connect to the nearest (DC${nearestDc.nearestDc})")
            }
            migrate(nearestDc.nearestDc)
        } else {
            Log.d(TAG, "Connected to the nearest DC${nearestDc.thisDc}")
        }
    }

    override fun close() = mtProtoHandler?.close() ?: Unit

    @Throws(IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): T {
        // BlockingObservable.first() will throw a RuntimeException if onError() is called by observable
        try {
            return mtProtoHandler!!.executeMethod(method).toBlocking().first()
        } catch(exception: RuntimeException) {
            when (exception.cause) {
                is RpcErrorException -> {
                    val error = (exception.cause as RpcErrorException).error
                    if (error.errorCode == 303) {
                        // DC error
                        Log.e(TAG, "Received DC error: " + error.message)
                        if (error.message.startsWith("PHONE_MIGRATE_")) {
                            migrate(error.message.removePrefix("PHONE_MIGRATE_").toInt())
                            return executeRpcQuery(method)
                        } else if (error.message.startsWith("FILE_MIGRATE_")) {
                            val migratedHandler = getMigratedMTProtoHandler(error.message.removePrefix("FILE_MIGRATE_").toInt())
                            try {
                                val result = migratedHandler.executeMethod(method).toBlocking().first()
                                migratedHandler.close()
                                return result
                            } catch (e: IOException) {
                                migratedHandler.close()
                            }
                        }
                    }
                    throw exception.cause as RpcErrorException
                }
                is IOException -> throw exception.cause as IOException
                else -> throw exception
            }
        }
    }

    @Throws(IOException::class)
    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    @Throws(IOException::class)
    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))

    private fun migrate(dcId: Int) {
        Log.d(TAG, "Migrating to DC$dcId")
        mtProtoHandler?.close()
        authKey = null
        dataCenter = Kotlogram.PROD_DCS[dcId - 1]
        apiStorage.deleteAuthKey()
        apiStorage.deleteDc()
        generateAuthKey = true

        init(checkNearestDc = false)
    }

    @Throws(IOException::class)
    private fun getMigratedMTProtoHandler(dcId: Int): MTProtoHandler {
        Log.d(TAG, "Creating handler on DC$dcId")
        val dc = Kotlogram.PROD_DCS[dcId - 1]
        val exportedAuthorization = authExportAuthorization(dcId)
        val authResult = AuthKeyCreation.createAuthKey(dc) ?: throw IOException("Couldn't create authorization key on DC$dcId")
        val mtProtoHandler = MTProtoHandler(authResult, null)
        mtProtoHandler.startWatchdog()
        initConnection(mtProtoHandler, TLRequestAuthImportAuthorization(exportedAuthorization.id, exportedAuthorization.bytes))
        return mtProtoHandler
    }

    override fun onUpdates(update: TLAbsUpdates) {
        when (update) {
            is TLUpdatesTooLong -> Unit
            is TLUpdateShortMessage -> Unit
            is TLUpdateShortChatMessage -> Unit
            is TLUpdateShort -> handleUpdate(update.update)
            is TLUpdatesCombined -> update.updates.forEach { u -> handleUpdate(u) }
            is TLUpdates -> update.updates.forEach { u -> handleUpdate(u) }
        }
    }

    fun handleUpdate(update: TLAbsUpdate): Unit? = when (update) {
        is TLUpdateNewMessage -> Unit
        is TLUpdateMessageID -> Unit
    //is TLUpdateReadMessages -> Unit
        is TLUpdateDeleteMessages -> Unit
    //is TLUpdateRestoreMessages -> Unit
        is TLUpdateUserTyping -> Unit
        is TLUpdateChatUserTyping -> Unit
        is TLUpdateChatParticipants -> Unit
        is TLUpdateUserStatus -> Unit
        is TLUpdateUserName -> Unit
        is TLUpdateUserPhoto -> Unit
        is TLUpdateContactRegistered -> Unit
        is TLUpdateContactLink -> Unit
    //is TLUpdateActivation -> Unit
        is TLUpdateNewAuthorization -> Unit
    //is TLUpdateNewGeoChatMessage -> Unit
        is TLUpdateNewEncryptedMessage -> Unit
        is TLUpdateEncryptedChatTyping -> Unit
        is TLUpdateEncryption -> Unit
        is TLUpdateEncryptedMessagesRead -> Unit
        is TLUpdateChatParticipantAdd -> Unit
        is TLUpdateChatParticipantDelete -> Unit
        is TLUpdateDcOptions -> Unit
        is TLUpdateUserBlocked -> Unit
        is TLUpdateNotifySettings -> Unit
        is TLUpdateServiceNotification -> Unit
        else -> Unit
    }

    override fun onSalt(salt: Long) = apiStorage.saveServerSalt(salt)
}