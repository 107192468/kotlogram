package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileMp4 extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0xb3cea0e4;

    public TLFileMp4() {
    }

    @Override
    public String toString() {
        return "storage.fileMp4#b3cea0e4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFileMp4)) return false;
        if (object == this) return true;

        TLFileMp4 o = (TLFileMp4) object;

        return true;
    }
}
