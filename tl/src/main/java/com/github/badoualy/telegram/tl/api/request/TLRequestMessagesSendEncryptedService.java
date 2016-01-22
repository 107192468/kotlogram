package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestMessagesSendEncryptedService extends TLMethod<TLAbsSentEncryptedMessage> {
    public static final int CLASS_ID = 0x32d439a4;

    protected TLInputEncryptedChat peer;

    protected long randomId;

    protected TLBytes data;

    public TLRequestMessagesSendEncryptedService() {
    }

    public TLRequestMessagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) {
        this.peer = peer;
        this.randomId = randomId;
        this.data = data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsSentEncryptedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsSentEncryptedMessage)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsSentEncryptedMessage) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeLong(randomId, stream);
        writeTLBytes(data, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = (com.github.badoualy.telegram.tl.api.TLInputEncryptedChat) readTLObject(stream, context);
        randomId = readLong(stream);
        data = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "messages.sendEncryptedService#32d439a4";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(TLInputEncryptedChat peer) {
        this.peer = peer;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }
}
