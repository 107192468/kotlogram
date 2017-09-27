package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readLong
import com.github.badoualy.telegram.tl.StreamUtils.writeLong
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTPing @JvmOverloads constructor(var pingId: Long = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(pingId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        pingId = readLong(stream)
    }

    override fun toString(): String {
        return "ping#7abe77ec"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 2059302892
    }
}
