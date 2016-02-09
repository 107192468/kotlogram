package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactLinkUnknown extends TLAbsContactLink {
    public static final int CONSTRUCTOR_ID = 0x5f4f9247;

    public TLContactLinkUnknown() {
    }

    @Override
    public String toString() {
        return "contactLinkUnknown#5f4f9247";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLContactLinkUnknown)) return false;
        if (object == this) return true;

        TLContactLinkUnknown o = (TLContactLinkUnknown) object;

        return true;
    }
}
