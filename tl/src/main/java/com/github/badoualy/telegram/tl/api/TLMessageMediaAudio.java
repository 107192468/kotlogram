package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaAudio extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0xc6b68300;

    protected TLAbsAudio audio;

    public TLMessageMediaAudio() {
    }

    public TLMessageMediaAudio(TLAbsAudio audio) {
        this.audio = audio;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(audio, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        audio = readTLObject(stream, context, TLAbsAudio.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += audio.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "messageMediaAudio#c6b68300";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsAudio getAudio() {
        return audio;
    }

    public void setAudio(TLAbsAudio audio) {
        this.audio = audio;
    }
}
