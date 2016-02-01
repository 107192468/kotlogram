package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLStringVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAuthSendInvites extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x771c1d97;

    protected TLStringVector phoneNumbers;

    protected String message;

    public TLRequestAuthSendInvites() {
    }

    public TLRequestAuthSendInvites(TLStringVector phoneNumbers, String message) {
        this.phoneNumbers = phoneNumbers;
        this.message = message;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(phoneNumbers, stream);
        writeTLString(message, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneNumbers = readTLStringVector(stream, context);
        message = readTLString(stream);
    }

    @Override
    public String toString() {
        return "auth.sendInvites#771c1d97";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLStringVector getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(TLStringVector phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
