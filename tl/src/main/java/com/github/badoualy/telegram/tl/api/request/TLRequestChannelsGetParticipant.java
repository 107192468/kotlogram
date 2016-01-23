package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestChannelsGetParticipant extends TLMethod<TLChannelParticipant> {
    public static final int CLASS_ID = 0x546dd7a6;

    protected TLAbsInputChannel channel;

    protected TLAbsInputUser userId;

    public TLRequestChannelsGetParticipant() {
    }

    public TLRequestChannelsGetParticipant(TLAbsInputChannel channel, TLAbsInputUser userId) {
        this.channel = channel;
        this.userId = userId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLChannelParticipant deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLChannelParticipant)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLChannelParticipant) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
        writeTLObject(userId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel) readTLObject(stream, context);
        userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "channels.getParticipant#546dd7a6";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }
}
