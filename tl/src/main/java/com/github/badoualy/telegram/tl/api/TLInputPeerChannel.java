package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerChannel extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x20adaef8;

    protected int channelId;

    protected long accessHash;

    public TLInputPeerChannel() {
    }

    public TLInputPeerChannel(int channelId, long accessHash) {
        this.channelId = channelId;
        this.accessHash = accessHash;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(channelId, stream);
        writeLong(accessHash, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readInt(stream);
        accessHash = readLong(stream);
    }

    @Override
    public String toString() {
        return "inputPeerChannel#20adaef8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }
}
