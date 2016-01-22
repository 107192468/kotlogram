package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactLinkUnknown extends TLAbsContactLink {
    public static final int CLASS_ID = 0x5f4f9247;

    public TLContactLinkUnknown() {
    }

    @Override
    public String toString() {
        return "contactLinkUnknown#5f4f9247";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
