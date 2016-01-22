package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsRecent extends TLAbsChannelParticipantsFilter {
    public static final int CLASS_ID = 0xde3f3c79;

    public TLChannelParticipantsRecent() {
    }

    @Override
    public String toString() {
        return "channelParticipantsRecent#de3f3c79";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
