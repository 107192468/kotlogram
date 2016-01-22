package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
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
public class TLRequestAccountChangePhone extends TLMethod<TLAbsUser> {
    public static final int CLASS_ID = 0x70c32edb;

    protected String phoneNumber;

    protected String phoneCodeHash;

    protected String phoneCode;

    public TLRequestAccountChangePhone() {
    }

    public TLRequestAccountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) {
        this.phoneNumber = phoneNumber;
        this.phoneCodeHash = phoneCodeHash;
        this.phoneCode = phoneCode;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUser deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUser)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUser) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(phoneNumber, stream);
        writeTLString(phoneCodeHash, stream);
        writeTLString(phoneCode, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneNumber = readTLString(stream);
        phoneCodeHash = readTLString(stream);
        phoneCode = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.changePhone#70c32edb";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String phoneCodeHash) {
        this.phoneCodeHash = phoneCodeHash;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
