
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLContactFound extends TLObject {

    public static final int CLASS_ID = 0xea879f95;

    public TLContactFound() {

    }


    public TLContactFound(        int _userId) {
        this.userId = _userId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
    }


    @Override
    public String toString() {
        return "contactFound#ea879f95";
    }

}
