package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputUserEmpty extends TLAbsInputUser {
    public static final int CONSTRUCTOR_ID = 0xb98886cf;

    public TLInputUserEmpty() {
    }

    @Override
    public String toString() {
        return "inputUserEmpty#b98886cf";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputUserEmpty)) return false;
        if (object == this) return true;

        TLInputUserEmpty o = (TLInputUserEmpty) object;

        return true;
    }
}
