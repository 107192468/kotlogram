package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerPack extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x12b299d4;

    protected String emoticon;

    protected TLLongVector documents;

    public TLStickerPack() {
    }

    public TLStickerPack(String emoticon, TLLongVector documents) {
        this.emoticon = emoticon;
        this.documents = documents;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(emoticon, stream);
        writeTLVector(documents, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        emoticon = readTLString(stream);
        documents = readTLLongVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(emoticon);
        size += documents.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "stickerPack#12b299d4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLStickerPack)) return false;
        if (object == this) return true;

        TLStickerPack o = (TLStickerPack) object;

        return (emoticon == o.emoticon || (emoticon != null && o.emoticon != null && emoticon.equals(o.emoticon)))
                && (documents == o.documents || (documents != null && o.documents != null && documents.equals(o.documents)));
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public TLLongVector getDocuments() {
        return documents;
    }

    public void setDocuments(TLLongVector documents) {
        this.documents = documents;
    }
}
