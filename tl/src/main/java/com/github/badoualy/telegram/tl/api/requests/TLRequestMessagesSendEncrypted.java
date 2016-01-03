
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesSendEncrypted extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage> {

    public static final int CLASS_ID = 0xa9776773;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSendEncrypted(        com.github.badoualy.telegram.tl.api.TLInputEncryptedChat _peer,         long _randomId,         TLBytes _data) {
        this.peer = _peer;
        this.randomId = _randomId;
        this.data = _data;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer;

    protected long randomId;

    protected TLBytes data;


    public com.github.badoualy.telegram.tl.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes value) {
        this.data = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeLong(this.randomId, stream);
        writeTLBytes(this.data, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.randomId = readLong(stream);
        this.data = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "messages.sendEncrypted#a9776773";
    }

}
