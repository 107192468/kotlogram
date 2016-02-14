package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyKeyStatusTimestamp extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xbc2eab30;

    private final String _constructor = "privacyKeyStatusTimestamp#bc2eab30";

    public TLPrivacyKeyStatusTimestamp() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLPrivacyKeyStatusTimestamp)) return false;
        if (object == this) return true;

        TLPrivacyKeyStatusTimestamp o = (TLPrivacyKeyStatusTimestamp) object;

        return true;
    }
}
