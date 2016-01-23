package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsChatFull;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatFull extends TLObject {
    public static final int CLASS_ID = 0xe5d7d19c;

    protected TLAbsChatFull fullChat;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    public TLChatFull() {
    }

    public TLChatFull(TLAbsChatFull fullChat, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.fullChat = fullChat;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(fullChat, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        fullChat = (com.github.badoualy.telegram.tl.api.TLAbsChatFull) readTLObject(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.chatFull#e5d7d19c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsChatFull getFullChat() {
        return fullChat;
    }

    public void setFullChat(TLAbsChatFull fullChat) {
        this.fullChat = fullChat;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
