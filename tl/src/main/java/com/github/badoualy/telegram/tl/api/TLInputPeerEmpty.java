package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerEmpty extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x7f3b18ea;

    public TLInputPeerEmpty() {
    }

    @Override
    public String toString() {
        return "inputPeerEmpty#7f3b18ea";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
