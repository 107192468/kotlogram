
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateChatParticipantDelete extends TLAbsUpdate {
    public static final int CLASS_ID = 0x6e5f8c22;

    public TLUpdateChatParticipantDelete() {

    }


    public TLUpdateChatParticipantDelete(        int _chatId,         int _userId,         int _version) {
        this.chatId = _chatId;
        this.userId = _userId;
        this.version = _version;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected int userId;

    protected int version;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.userId, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = readInt(stream);
        this.version = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateChatParticipantDelete#6e5f8c22";
    }

}
