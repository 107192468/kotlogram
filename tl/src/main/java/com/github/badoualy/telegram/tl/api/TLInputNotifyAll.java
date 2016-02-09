package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputNotifyAll extends TLAbsInputNotifyPeer {
    public static final int CONSTRUCTOR_ID = 0xa429b886;

    public TLInputNotifyAll() {
    }

    @Override
    public String toString() {
        return "inputNotifyAll#a429b886";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputNotifyAll)) return false;
        if (object == this) return true;

        TLInputNotifyAll o = (TLInputNotifyAll) object;

        return true;
    }
}
