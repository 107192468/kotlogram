package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLTermsOfService extends TLObject {
    public static final int CLASS_ID = 0xf1ee3e90;

    protected String text;

    public TLTermsOfService() {
    }

    public TLTermsOfService(String text) {
        this.text = text;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(text, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLString(stream);
    }

    @Override
    public String toString() {
        return "help.termsOfService#f1ee3e90";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
