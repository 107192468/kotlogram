package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUpdatesGetState : TLMethod<TLState>() {
    private val _constructor: String = "updates.getState#edd4882a"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLState = tlDeserializer.readTLObject()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUpdatesGetState) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xedd4882a.toInt()
    }
}
