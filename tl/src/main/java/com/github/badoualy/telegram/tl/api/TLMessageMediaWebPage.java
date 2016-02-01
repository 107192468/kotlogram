package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaWebPage extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0xa32dd600;

    protected TLAbsWebPage webpage;

    public TLMessageMediaWebPage() {
    }

    public TLMessageMediaWebPage(TLAbsWebPage webpage) {
        this.webpage = webpage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(webpage, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        webpage = (com.github.badoualy.telegram.tl.api.TLAbsWebPage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messageMediaWebPage#a32dd600";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsWebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(TLAbsWebPage webpage) {
        this.webpage = webpage;
    }
}
