package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSavedGifs extends TLAbsSavedGifs {
    public static final int CONSTRUCTOR_ID = 0x2e0709a5;

    protected int hash;

    protected TLVector<? extends TLAbsDocument> gifs;

    public TLSavedGifs() {
    }

    public TLSavedGifs(int hash, TLVector<? extends TLAbsDocument> gifs) {
        this.hash = hash;
        this.gifs = gifs;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(gifs, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        gifs = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += gifs.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "messages.savedGifs#2e0709a5";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLSavedGifs)) return false;
        if (object == this) return true;

        TLSavedGifs o = (TLSavedGifs) object;

        return hash == o.hash
                && (gifs == o.gifs || (gifs != null && o.gifs != null && gifs.equals(o.gifs)));
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<? extends TLAbsDocument> getGifs() {
        return gifs;
    }

    public void setGifs(TLVector<? extends TLAbsDocument> gifs) {
        this.gifs = gifs;
    }
}
