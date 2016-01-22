package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLStickerSet;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLAllStickers extends TLAbsAllStickers {
    public static final int CLASS_ID = 0xedfd405f;

    protected int hash;

    protected TLVector<TLStickerSet> sets;

    public TLAllStickers() {
    }

    public TLAllStickers(int hash, TLVector<TLStickerSet> sets) {
        this.hash = hash;
        this.sets = sets;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(sets, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        sets = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.allStickers#edfd405f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<TLStickerSet> getSets() {
        return sets;
    }

    public void setSets(TLVector<TLStickerSet> sets) {
        this.sets = sets;
    }
}
