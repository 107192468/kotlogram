package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdateShort extends TLAbsUpdates {
    public static final int CLASS_ID = 0x78d4dec1;

    protected TLAbsUpdate update;

    protected int date;

    public TLUpdateShort() {
    }

    public TLUpdateShort(TLAbsUpdate update, int date) {
        this.update = update;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(update, stream);
        writeInt(date, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        update = (com.github.badoualy.telegram.tl.api.TLAbsUpdate) readTLObject(stream, context);
        date = readInt(stream);
    }

    @Override
    public String toString() {
        return "updateShort#78d4dec1";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsUpdate getUpdate() {
        return update;
    }

    public void setUpdate(TLAbsUpdate update) {
        this.update = update;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
