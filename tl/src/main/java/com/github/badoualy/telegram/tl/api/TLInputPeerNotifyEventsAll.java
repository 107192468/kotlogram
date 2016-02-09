package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerNotifyEventsAll extends TLAbsInputPeerNotifyEvents {
    public static final int CONSTRUCTOR_ID = 0xe86a2c74;

    public TLInputPeerNotifyEventsAll() {
    }

    @Override
    public String toString() {
        return "inputPeerNotifyEventsAll#e86a2c74";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPeerNotifyEventsAll)) return false;
        if (object == this) return true;

        TLInputPeerNotifyEventsAll o = (TLInputPeerNotifyEventsAll) object;

        return true;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLInputPeerNotifyEventsAll getAsInputPeerNotifyEventsAll() {
        return this;
    }
}
