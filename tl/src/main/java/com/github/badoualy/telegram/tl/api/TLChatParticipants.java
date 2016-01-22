package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLChatParticipants extends TLAbsChatParticipants {
    public static final int CLASS_ID = 0x3f460fed;

    protected TLVector<TLAbsChatParticipant> participants;

    protected int version;

    public TLChatParticipants() {
    }

    public TLChatParticipants(int chatId, TLVector<TLAbsChatParticipant> participants, int version) {
        this.chatId = chatId;
        this.participants = participants;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(chatId, stream);
        writeTLVector(participants, stream);
        writeInt(version, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readInt(stream);
        participants = readTLVector(stream, context);
        version = readInt(stream);
    }

    @Override
    public String toString() {
        return "chatParticipants#3f460fed";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public TLVector<TLAbsChatParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<TLAbsChatParticipant> participants) {
        this.participants = participants;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
