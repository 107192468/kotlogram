package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.StreamUtils.readInt
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLIntVector : TLVector<Int>() {

    @Throws(IOException::class)
    override fun serializeItem(item: Int, tlSerializer: TLSerializer) {
        tlSerializer.writeInt(item)
    }

    @Throws(IOException::class)
    override fun deserializeItem(tlDeserializer: TLDeserializer): Int = tlDeserializer.readInt()

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 + SIZE_INT32 * size

    override fun toString() = "vector<int>#1cb5c415"

}
