package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.TLContext

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.Arrays

import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLGzipObject(var packedData: ByteArray? = null) : TLObject() {

    override val constructorId: Int
        get() = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        StreamUtils.writeTLBytes(packedData, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        packedData = StreamUtils.readTLBytes(stream)
    }

    override fun computeSerializedSize(): Int =
            CONSTRUCTOR_ID + computeTLBytesSerializedSize(packedData!!.size)

    override fun toString() = "gzip_packed#3072cfa1"

    override fun equals(other: Any?): Boolean {
        if (other !is TLGzipObject)
            return false
        if (this === other)
            return true

        return Arrays.equals(packedData, other.packedData)
    }

    override fun hashCode() = packedData?.let { Arrays.hashCode(it) } ?: 0

    companion object {
        const val CONSTRUCTOR_ID = 0x3072cfa1
    }
}
