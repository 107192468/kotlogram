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
public class TLMessageActionChatEditTitle extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xb5a1ce5a;

    protected String title;

    public TLMessageActionChatEditTitle() {
    }

    public TLMessageActionChatEditTitle(String title) {
        this.title = title;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(title, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        title = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messageActionChatEditTitle#b5a1ce5a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
