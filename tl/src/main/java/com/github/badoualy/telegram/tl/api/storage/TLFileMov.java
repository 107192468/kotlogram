package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileMov extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0x4b09ebbc;

    public TLFileMov() {
    }

    @Override
    public String toString() {
        return "storage.fileMov#4b09ebbc";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
