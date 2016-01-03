
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestContactsDeleteContact extends TLMethod<com.github.badoualy.telegram.tl.api.contacts.TLLink> {

    public static final int CLASS_ID = 0x8e953744;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsDeleteContact(        com.github.badoualy.telegram.tl.api.TLAbsInputUser _id) {
        this.id = _id;

    }



    public com.github.badoualy.telegram.tl.api.contacts.TLLink deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.contacts.TLLink) {
            return (com.github.badoualy.telegram.tl.api.contacts.TLLink)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.contacts.TLLink, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser id;


    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "contacts.deleteContact#8e953744";
    }

}
