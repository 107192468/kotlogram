package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsMessageMedia;
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
public class TLRequestMessagesGetWebPagePreview extends TLMethod<TLAbsMessageMedia> {
    public static final int CLASS_ID = 0x25223e24;

    protected String message;

    public TLRequestMessagesGetWebPagePreview() {
    }

    public TLRequestMessagesGetWebPagePreview(String message) {
        this.message = message;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsMessageMedia deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsMessageMedia)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsMessageMedia) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(message, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        message = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messages.getWebPagePreview#25223e24";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
