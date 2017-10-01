package com.github.badoualy.telegram.tl.api

/**
 * documentAttributeHasStickers#9801d2f7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeHasStickers : TLAbsDocumentAttribute() {
    private val _constructor: String = "documentAttributeHasStickers#9801d2f7"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeHasStickers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9801d2f7.toInt()
    }
}
