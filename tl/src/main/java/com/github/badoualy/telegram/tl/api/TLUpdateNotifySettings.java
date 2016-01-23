package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateNotifySettings extends TLAbsUpdate {
    public static final int CLASS_ID = 0xbec268ef;

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
        peer = (com.github.badoualy.telegram.tl.api.TLAbsNotifyPeer) readTLObject(stream, context);
        notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "updateNotifySettings#bec268ef";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
