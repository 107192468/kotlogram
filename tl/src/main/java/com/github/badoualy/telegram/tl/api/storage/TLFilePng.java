package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFilePng extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0xa4f63c0;

    public TLFilePng() {
    }

    @Override
    public String toString() {
        return "storage.filePng#a4f63c0";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFilePng)) return false;
        if (object == this) return true;

        TLFilePng o = (TLFilePng) object;

        return true;
    }
}
