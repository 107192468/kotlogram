package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeSticker extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x3a556302;

    protected String alt;

    protected TLAbsInputStickerSet stickerset;

    private final String _constructor = "documentAttributeSticker#3a556302";

    public TLDocumentAttributeSticker() {
    }

    public TLDocumentAttributeSticker(String alt, TLAbsInputStickerSet stickerset) {
        this.alt = alt;
        this.stickerset = stickerset;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(alt, stream);
        writeTLObject(stickerset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        alt = readTLString(stream);
        stickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(alt);
        size += stickerset.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLDocumentAttributeSticker)) return false;
        if (object == this) return true;

        TLDocumentAttributeSticker o = (TLDocumentAttributeSticker) object;

        return (alt == o.alt || (alt != null && o.alt != null && alt.equals(o.alt)))
                && (stickerset == o.stickerset || (stickerset != null && o.stickerset != null && stickerset.equals(o.stickerset)));
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
