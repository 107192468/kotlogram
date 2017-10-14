package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class ClientDhInner @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                              var serverNonce: ByteArray = ByteArray(0),
                                              var retryId: Long = 0,
                                              var gb: ByteArray = ByteArray(0)) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeLong(retryId)
        writeTLBytes(gb)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readBytes(16)
        serverNonce = readBytes(16)
        retryId = readLong()
        gb = readTLBytesAsBytes()
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1715713620
    }
}
