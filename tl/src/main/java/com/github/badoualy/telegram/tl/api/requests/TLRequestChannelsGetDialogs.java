
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestChannelsGetDialogs extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs> {

    public static final int CLASS_ID = 0xa9d3d249;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsGetDialogs(        int _offset,         int _limit) {
        this.offset = _offset;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int offset;

    protected int limit;


    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.offset, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offset = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "channels.getDialogs#a9d3d249";
    }

}
