package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesForwardMessages extends TLMethod<TLAbsUpdates> {
    public static final int CLASS_ID = 0x708e0195;

    protected int flags;

    protected boolean broadcast;

    protected TLAbsInputPeer fromPeer;

    protected TLVector<Integer> id;

    protected TLVector<Long> randomId;

    protected TLAbsInputPeer toPeer;

    public TLRequestMessagesForwardMessages() {
    }

    public TLRequestMessagesForwardMessages(int flags, boolean broadcast, TLAbsInputPeer fromPeer, TLVector<Integer> id, TLVector<Long> randomId, TLAbsInputPeer toPeer) {
        this.flags = flags;
        this.broadcast = broadcast;
        this.fromPeer = fromPeer;
        this.id = id;
        this.randomId = randomId;
        this.toPeer = toPeer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = broadcast ? (flags | 16) : (flags &~ 16);

        writeInt(flags, stream);
        if ((flags & 16) != 0) writeTLBool(broadcast, stream);
        writeTLObject(fromPeer, stream);
        writeTLVector(id, stream);
        writeTLVector(randomId, stream);
        writeTLObject(toPeer, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        broadcast = (flags & 16) != 0;
        fromPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer) readTLObject(stream, context);
        id = readTLVector(stream, context);
        randomId = readTLVector(stream, context);
        toPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messages.forwardMessages#708e0195";
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

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public TLAbsInputPeer getFromPeer() {
        return fromPeer;
    }

    public void setFromPeer(TLAbsInputPeer fromPeer) {
        this.fromPeer = fromPeer;
    }

    public TLVector<Integer> getId() {
        return id;
    }

    public void setId(TLVector<Integer> id) {
        this.id = id;
    }

    public TLVector<Long> getRandomId() {
        return randomId;
    }

    public void setRandomId(TLVector<Long> randomId) {
        this.randomId = randomId;
    }

    public TLAbsInputPeer getToPeer() {
        return toPeer;
    }

    public void setToPeer(TLAbsInputPeer toPeer) {
        this.toPeer = toPeer;
    }
}
