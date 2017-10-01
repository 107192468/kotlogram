package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * privacyValueAllowUsers#4d5bbe0c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyValueAllowUsers() : TLAbsPrivacyRule() {
    var users: TLIntVector = TLIntVector()

    private val _constructor: String = "privacyValueAllowUsers#4d5bbe0c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(users: TLIntVector) : this() {
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        users = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyValueAllowUsers) return false
        if (other === this) return true

        return users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4d5bbe0c.toInt()
    }
}
