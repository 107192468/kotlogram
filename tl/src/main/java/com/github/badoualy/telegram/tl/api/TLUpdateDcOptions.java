package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateDcOptions extends TLAbsUpdate {
    public static final int CLASS_ID = 0x8e5e9873;

    protected TLVector<TLDcOption> dcOptions;

    public TLUpdateDcOptions() {
    }

    public TLUpdateDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(dcOptions, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcOptions = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "updateDcOptions#8e5e9873";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }
}
