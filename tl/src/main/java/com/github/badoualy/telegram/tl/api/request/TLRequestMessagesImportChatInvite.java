package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
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
public class TLRequestMessagesImportChatInvite extends TLMethod<TLAbsUpdates> {
    public static final int CLASS_ID = 0x6c50051c;

    protected String hash;

    public TLRequestMessagesImportChatInvite() {
    }

    public TLRequestMessagesImportChatInvite(String hash) {
        this.hash = hash;
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
        writeTLString(hash, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messages.importChatInvite#6c50051c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
