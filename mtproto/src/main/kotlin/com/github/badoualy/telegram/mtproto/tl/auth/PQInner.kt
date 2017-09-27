package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

open class PQInner @JvmOverloads constructor(var pq: ByteArray = ByteArray(0),
                                             var p: ByteArray = ByteArray(0),
                                             var q: ByteArray = ByteArray(0),
                                             var nonce: ByteArray = ByteArray(0),
                                             var serverNonce: ByteArray = ByteArray(0),
                                             var newNonce: ByteArray = ByteArray(0)) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeTLBytes(pq)
        writeTLBytes(p)
        writeTLBytes(q)
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeByteArray(newNonce)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        pq = readTLBytes(stream)
        p = readTLBytes(stream)
        q = readTLBytes(stream)
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        newNonce = readBytes(32, stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -2083955988
    }
}
