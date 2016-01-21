
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestContactsResolveUsername extends TLMethod<com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer> {

    public static final int CLASS_ID = 0xf93ccba3;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsResolveUsername(        String _username) {
        this.username = _username;

    }



    public com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer) {
            return (com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.username, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.username = readTLString(stream);
    }



    @Override
    public String toString() {
        return "contacts.resolveUsername#f93ccba3";
    }

}
