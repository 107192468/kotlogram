package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockCollage#8b31c4f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockCollage() : TLAbsPageBlock() {
    var items: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    var caption: TLAbsRichText = TLTextEmpty()

    private val _constructor: String = "pageBlockCollage#8b31c4f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(items: TLObjectVector<TLAbsPageBlock>, caption: TLAbsRichText) : this() {
        this.items = items
        this.caption = caption
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(items)
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        items = readTLVector<TLAbsPageBlock>()
        caption = readTLObject<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += items.computeSerializedSize()
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockCollage) return false
        if (other === this) return true

        return items == other.items
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8b31c4f.toInt()
    }
}
