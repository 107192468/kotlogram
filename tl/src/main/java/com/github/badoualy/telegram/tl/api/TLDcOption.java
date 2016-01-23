package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDcOption extends TLObject {
    public static final int CLASS_ID = 0x5d8c6cc;

    protected int flags;

    protected boolean ipv6;

    protected boolean mediaOnly;

    protected int id;

    protected String ipAddress;

    protected int port;

    public TLDcOption() {
    }

    public TLDcOption(int flags, boolean ipv6, boolean mediaOnly, int id, String ipAddress, int port) {
        this.flags = flags;
        this.ipv6 = ipv6;
        this.mediaOnly = mediaOnly;
        this.id = id;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = ipv6 ? (flags | 1) : (flags &~ 1);
        flags = mediaOnly ? (flags | 2) : (flags &~ 2);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(ipv6, stream);
        if ((flags & 2) != 0) writeTLBool(mediaOnly, stream);
        writeInt(id, stream);
        writeTLString(ipAddress, stream);
        writeInt(port, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        ipv6 = (flags & 1) != 0;
        mediaOnly = (flags & 2) != 0;
        id = readInt(stream);
        ipAddress = readTLString(stream);
        port = readInt(stream);
    }

    @Override
    public String toString() {
        return "dcOption#5d8c6cc";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public boolean getIpv6() {
        return ipv6;
    }

    public void setIpv6(boolean ipv6) {
        this.ipv6 = ipv6;
    }

    public boolean getMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
