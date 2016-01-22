package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAppChangelogEmpty extends TLAbsAppChangelog {
    public static final int CLASS_ID = 0xaf7e0394;

    public TLAppChangelogEmpty() {
    }

    @Override
    public String toString() {
        return "help.appChangelogEmpty#af7e0394";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
