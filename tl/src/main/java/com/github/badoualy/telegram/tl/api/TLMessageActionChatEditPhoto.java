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
public class TLMessageActionChatEditPhoto extends TLAbsMessageAction {
    public static final int CLASS_ID = 0x7fcb13a8;

    protected TLAbsPhoto photo;

    public TLMessageActionChatEditPhoto() {
    }

    public TLMessageActionChatEditPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(photo, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messageActionChatEditPhoto#7fcb13a8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }
}
