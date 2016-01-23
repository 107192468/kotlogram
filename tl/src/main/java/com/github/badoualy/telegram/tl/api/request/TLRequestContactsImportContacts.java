package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLInputPhoneContact;
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestContactsImportContacts extends TLMethod<TLImportedContacts> {
    public static final int CLASS_ID = 0xda30b32d;

    protected TLVector<TLInputPhoneContact> contacts;

    protected boolean replace;

    public TLRequestContactsImportContacts() {
    }

    public TLRequestContactsImportContacts(TLVector<TLInputPhoneContact> contacts, boolean replace) {
        this.contacts = contacts;
        this.replace = replace;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLImportedContacts deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLImportedContacts)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLImportedContacts) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(contacts, stream);
        writeTLBool(replace, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        contacts = readTLVector(stream, context);
        replace = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "contacts.importContacts#da30b32d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLInputPhoneContact> getContacts() {
        return contacts;
    }

    public void setContacts(TLVector<TLInputPhoneContact> contacts) {
        this.contacts = contacts;
    }

    public boolean getReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }
}
