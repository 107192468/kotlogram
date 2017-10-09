package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.util.regex.Pattern

class MTRpcError @JvmOverloads constructor(var errorCode: Int = 0,
                                           var message: String = "") : TLObject() {

    val errorTag: String
        get() {
            if (message.isEmpty())
                return "DEFAULT"

            val matcher = REGEXP_PATTERN.matcher(message)
            if (matcher.find())
                return matcher.group()

            return "DEFAULT"
        }

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeInt(errorCode)
        writeString(message)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        errorCode = readInt()
        message = readString()
    }

    override fun toString(): String {
        return "rpc_error#2144ca19"
    }

    companion object {
        private val REGEXP_PATTERN = Pattern.compile("[A-Z_0-9]+")

        @JvmField
        val CONSTRUCTOR_ID = 558156313
    }
}
