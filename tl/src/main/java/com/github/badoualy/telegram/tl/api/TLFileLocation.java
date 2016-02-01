package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileLocation extends TLAbsFileLocation {
    public static final int CONSTRUCTOR_ID = 0x53d69076;

    protected int dcId;

    public TLFileLocation() {
    }

    public TLFileLocation(int dcId, long volumeId, int localId, long secret) {
        this.dcId = dcId;
        this.volumeId = volumeId;
        this.localId = localId;
        this.secret = secret;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(dcId, stream);
        writeLong(volumeId, stream);
        writeInt(localId, stream);
        writeLong(secret, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcId = readInt(stream);
        volumeId = readLong(stream);
        localId = readInt(stream);
        secret = readLong(stream);
    }

    @Override
    public String toString() {
        return "fileLocation#53d69076";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(long volumeId) {
        this.volumeId = volumeId;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long secret) {
        this.secret = secret;
    }
}
