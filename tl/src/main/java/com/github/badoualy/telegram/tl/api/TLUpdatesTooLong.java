package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdatesTooLong extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0xe317af7e;

    public TLUpdatesTooLong() {
    }

    @Override
    public String toString() {
        return "updatesTooLong#e317af7e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdatesTooLong)) return false;
        if (object == this) return true;

        TLUpdatesTooLong o = (TLUpdatesTooLong) object;

        return true;
    }
}
