package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeAudio extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0xded218e0;

    protected int duration;

    protected String title;

    protected String performer;

    private final String _constructor = "documentAttributeAudio#ded218e0";

    public TLDocumentAttributeAudio() {
    }

    public TLDocumentAttributeAudio(int duration, String title, String performer) {
        this.duration = duration;
        this.title = title;
        this.performer = performer;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(duration, stream);
        writeString(title, stream);
        writeString(performer, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        duration = readInt(stream);
        title = readTLString(stream);
        performer = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(performer);
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
        if (!(object instanceof TLDocumentAttributeAudio)) return false;
        if (object == this) return true;

        TLDocumentAttributeAudio o = (TLDocumentAttributeAudio) object;

        return duration == o.duration
                && (title == o.title || (title != null && o.title != null && title.equals(o.title)))
                && (performer == o.performer || (performer != null && o.performer != null && performer.equals(o.performer)));
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }
}
