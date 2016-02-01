package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineMediaResultDocument extends TLAbsBotInlineResult {
    public static final int CONSTRUCTOR_ID = 0xf897d33e;

    protected TLAbsDocument document;

    public TLBotInlineMediaResultDocument() {
    }

    public TLBotInlineMediaResultDocument(String id, String type, TLAbsDocument document, TLAbsBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.document = document;
        this.sendMessage = sendMessage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(id, stream);
        writeString(type, stream);
        writeTLObject(document, stream);
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLString(stream);
        type = readTLString(stream);
        document = (com.github.badoualy.telegram.tl.api.TLAbsDocument) readTLObject(stream, context);
        sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "botInlineMediaResultDocument#f897d33e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
