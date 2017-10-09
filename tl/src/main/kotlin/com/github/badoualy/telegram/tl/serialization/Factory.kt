package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.TLContext
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

interface TLSerializerFactory {
    fun createSerializer(size: Int = 0): TLSerializer
    fun createDeserializer(payload: ByteArray, context: TLContext): TLDeserializer
    fun createDeserializer(stream: InputStream, context: TLContext): TLDeserializer
}

object TLStreamSerializerFactory : TLSerializerFactory {

    override fun createSerializer(size: Int): TLSerializer =
            TLStreamSerializer(ByteArrayOutputStream(size))

    override fun createDeserializer(payload: ByteArray, context: TLContext): TLDeserializer =
            createDeserializer(ByteArrayInputStream(payload), context)

    override fun createDeserializer(stream: InputStream, context: TLContext): TLDeserializer =
            TLStreamDeserializer(stream, context)

}