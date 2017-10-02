package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthRequestPasswordRecovery : TLMethod<TLPasswordRecovery>() {
    private val _constructor: String = "auth.requestPasswordRecovery#d897bc66"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLPasswordRecovery = tlDeserializer.readTLObject(TLPasswordRecovery::class, TLPasswordRecovery.CONSTRUCTOR_ID)

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthRequestPasswordRecovery) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd897bc66.toInt()
    }
}
