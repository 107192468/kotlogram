
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLContact extends TLObject {

    public static final int CLASS_ID = 0xf911c994;

    public TLContact() {

    }


    public TLContact(        int _userId,         boolean _mutual) {
        this.userId = _userId;
        this.mutual = _mutual;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected boolean mutual;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public boolean getMutual() {
        return mutual;
    }

    public void setMutual(boolean value) {
        this.mutual = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLBool(this.mutual, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.mutual = readTLBool(stream);
    }


    @Override
    public String toString() {
        return "contact#f911c994";
    }

}
