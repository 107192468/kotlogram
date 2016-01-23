package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesDeleteMessages extends TLMethod<TLAffectedMessages> {
    public static final int CLASS_ID = 0xa5f18925;

    protected TLVector<Integer> id;

    public TLRequestMessagesDeleteMessages() {
    }

    public TLRequestMessagesDeleteMessages(TLVector<Integer> id) {
        this.id = id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAffectedMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAffectedMessages)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAffectedMessages) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(id, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.deleteMessages#a5f18925";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<Integer> getId() {
        return id;
    }

    public void setId(TLVector<Integer> id) {
        this.id = id;
    }
}
