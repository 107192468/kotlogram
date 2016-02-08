package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateNotifySettings extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xbec268ef;

    protected TLAbsNotifyPeer peer;

    protected TLAbsPeerNotifySettings notifySettings;

    public TLUpdateNotifySettings() {
    }

    public TLUpdateNotifySettings(TLAbsNotifyPeer peer, TLAbsPeerNotifySettings notifySettings) {
        this.peer = peer;
        this.notifySettings = notifySettings;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(notifySettings, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = (TLAbsNotifyPeer) readTLObject(stream, context);
        notifySettings = (TLAbsPeerNotifySettings) readTLObject(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updateNotifySettings#bec268ef";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsNotifyPeer peer) {
        this.peer = peer;
    }

    public TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLAbsPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }
}
