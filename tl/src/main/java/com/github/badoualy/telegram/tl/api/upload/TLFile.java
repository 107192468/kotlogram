package com.github.badoualy.telegram.tl.api.upload;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.storage.TLAbsFileType;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFile extends TLObject {
    public static final int CLASS_ID = 0x96a18d5;

    protected TLAbsFileType type;

    protected int mtime;

    protected TLBytes bytes;

    public TLFile() {
    }

    public TLFile(TLAbsFileType type, int mtime, TLBytes bytes) {
        this.type = type;
        this.mtime = mtime;
        this.bytes = bytes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(type, stream);
        writeInt(mtime, stream);
        writeTLBytes(bytes, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = (com.github.badoualy.telegram.tl.api.storage.TLAbsFileType) readTLObject(stream, context);
        mtime = readInt(stream);
        bytes = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "upload.file#96a18d5";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsFileType getType() {
        return type;
    }

    public void setType(TLAbsFileType type) {
        this.type = type;
    }

    public int getMtime() {
        return mtime;
    }

    public void setMtime(int mtime) {
        this.mtime = mtime;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }
}
