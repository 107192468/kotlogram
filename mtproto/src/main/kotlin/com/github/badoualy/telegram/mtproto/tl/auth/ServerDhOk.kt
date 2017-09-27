package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ServerDhOk @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                           var serverNonce: ByteArray = ByteArray(0),
                                           var encryptedAnswer: ByteArray = ByteArray(0))
    : ServerDhParams() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeTLBytes(encryptedAnswer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        encryptedAnswer = readTLBytes(stream)
    }

    override fun toString() = "server_DH_params_ok#d0e8075c"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -790100132
    }
}
