package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateStickerSets extends TLAbsUpdate {
    public static final int CLASS_ID = 0x43ae3dec;

    public TLUpdateStickerSets() {
    }

    @Override
    public String toString() {
        return "updateStickerSets#43ae3dec";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
