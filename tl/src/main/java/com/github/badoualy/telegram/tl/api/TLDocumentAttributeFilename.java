package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeFilename extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x15590068;

    protected String fileName;

    private final String _constructor = "documentAttributeFilename#15590068";

    public TLDocumentAttributeFilename() {
    }

    public TLDocumentAttributeFilename(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(fileName, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        fileName = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(fileName);
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
        if (!(object instanceof TLDocumentAttributeFilename)) return false;
        if (object == this) return true;

        TLDocumentAttributeFilename o = (TLDocumentAttributeFilename) object;

        return (fileName == o.fileName || (fileName != null && o.fileName != null && fileName.equals(o.fileName)));
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
