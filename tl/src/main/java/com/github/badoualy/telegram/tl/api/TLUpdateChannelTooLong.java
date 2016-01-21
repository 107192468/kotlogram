
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLUpdateChannelTooLong extends TLAbsUpdate {
    public static final int CLASS_ID = 0x60946422;

    public TLUpdateChannelTooLong() {

    }


    public TLUpdateChannelTooLong(        int _channelId) {
        this.channelId = _channelId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int channelId;


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int value) {
        this.channelId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.channelId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channelId = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateChannelTooLong#60946422";
    }

}
