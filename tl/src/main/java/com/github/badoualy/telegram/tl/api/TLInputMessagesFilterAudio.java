package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterAudio extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0xcfc87522;

    public TLInputMessagesFilterAudio() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterAudio#cfc87522";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
