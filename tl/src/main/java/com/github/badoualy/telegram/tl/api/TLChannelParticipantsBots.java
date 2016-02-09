package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsBots extends TLAbsChannelParticipantsFilter {
    public static final int CONSTRUCTOR_ID = 0xb0d1865b;

    public TLChannelParticipantsBots() {
    }

    @Override
    public String toString() {
        return "channelParticipantsBots#b0d1865b";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelParticipantsBots)) return false;
        if (object == this) return true;

        TLChannelParticipantsBots o = (TLChannelParticipantsBots) object;

        return true;
    }
}
