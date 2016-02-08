package com.github.badoualy.telegram.tl.api.updates;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUpdate;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDifference extends TLAbsDifference {
    public static final int CONSTRUCTOR_ID = 0xf49ca0;

    protected TLVector<? extends TLAbsMessage> newMessages;

    protected TLVector<? extends TLAbsEncryptedMessage> newEncryptedMessages;

    protected TLVector<? extends TLAbsUpdate> otherUpdates;

    protected TLVector<? extends TLAbsChat> chats;

    protected TLVector<? extends TLAbsUser> users;

    protected TLState state;

    public TLDifference() {
    }

    public TLDifference(TLVector<? extends TLAbsMessage> newMessages, TLVector<? extends TLAbsEncryptedMessage> newEncryptedMessages, TLVector<? extends TLAbsUpdate> otherUpdates, TLVector<? extends TLAbsChat> chats, TLVector<? extends TLAbsUser> users, TLState state) {
        this.newMessages = newMessages;
        this.newEncryptedMessages = newEncryptedMessages;
        this.otherUpdates = otherUpdates;
        this.chats = chats;
        this.users = users;
        this.state = state;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(newMessages, stream);
        writeTLVector(newEncryptedMessages, stream);
        writeTLVector(otherUpdates, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        writeTLObject(state, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        newMessages = readTLVector(stream, context);
        newEncryptedMessages = readTLVector(stream, context);
        otherUpdates = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        state = readTLObject(stream, context, TLState.class, TLState.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += newMessages.computeSerializedSize();
        size += newEncryptedMessages.computeSerializedSize();
        size += otherUpdates.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        size += state.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updates.difference#f49ca0";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLVector<? extends TLAbsMessage> getNewMessages() {
        return newMessages;
    }

    public void setNewMessages(TLVector<? extends TLAbsMessage> newMessages) {
        this.newMessages = newMessages;
    }

    public TLVector<? extends TLAbsEncryptedMessage> getNewEncryptedMessages() {
        return newEncryptedMessages;
    }

    public void setNewEncryptedMessages(TLVector<? extends TLAbsEncryptedMessage> newEncryptedMessages) {
        this.newEncryptedMessages = newEncryptedMessages;
    }

    public TLVector<? extends TLAbsUpdate> getOtherUpdates() {
        return otherUpdates;
    }

    public void setOtherUpdates(TLVector<? extends TLAbsUpdate> otherUpdates) {
        this.otherUpdates = otherUpdates;
    }

    public TLVector<? extends TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<? extends TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }

    public TLState getState() {
        return state;
    }

    public void setState(TLState state) {
        this.state = state;
    }
}
