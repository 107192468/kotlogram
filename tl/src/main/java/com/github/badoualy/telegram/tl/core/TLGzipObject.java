package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.StreamUtils;
import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGzipObject extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x3072cfa1;

    private byte[] packedData;

    public TLGzipObject() {

    }

    public TLGzipObject(byte[] packedData) {
        this.packedData = packedData;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        StreamUtils.writeTLBytes(packedData, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        packedData = StreamUtils.readTLBytes(stream);
    }

    @Override
    public String toString() {
        return "gzip_packed#3072cfa1";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public byte[] getPackedData() {
        return packedData;
    }

    public void setPackedData(byte[] packedData) {
        this.packedData = packedData;
    }
}
