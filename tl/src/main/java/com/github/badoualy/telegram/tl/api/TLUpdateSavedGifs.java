package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateSavedGifs extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x9375341e;

    public TLUpdateSavedGifs() {
    }

    @Override
    public String toString() {
        return "updateSavedGifs#9375341e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateSavedGifs)) return false;
        if (object == this) return true;

        TLUpdateSavedGifs o = (TLUpdateSavedGifs) object;

        return true;
    }
}
