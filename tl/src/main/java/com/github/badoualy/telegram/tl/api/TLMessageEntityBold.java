package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageEntityBold extends TLAbsMessageEntity {
    public static final int CONSTRUCTOR_ID = 0xbd610bc9;

    public TLMessageEntityBold() {
    }

    public TLMessageEntityBold(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(offset, stream);
        writeInt(length, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        offset = readInt(stream);
        length = readInt(stream);
    }

    @Override
    public String toString() {
        return "messageEntityBold#bd610bc9";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
