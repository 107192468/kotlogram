
package com.github.badoualy.telegram.tl.api.updates;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLDifference extends TLAbsDifference {
    public static final int CLASS_ID = 0xf49ca0;

    public TLDifference() {

    }


    public TLDifference(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> _newMessages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> _newEncryptedMessages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> _otherUpdates,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users,         com.github.badoualy.telegram.tl.api.updates.TLState _state) {
        this.newMessages = _newMessages;
        this.newEncryptedMessages = _newEncryptedMessages;
        this.otherUpdates = _otherUpdates;
        this.chats = _chats;
        this.users = _users;
        this.state = _state;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> newMessages;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> newEncryptedMessages;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> otherUpdates;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> chats;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;

    protected com.github.badoualy.telegram.tl.api.updates.TLState state;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> getNewMessages() {
        return newMessages;
    }

    public void setNewMessages(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> value) {
        this.newMessages = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> getNewEncryptedMessages() {
        return newEncryptedMessages;
    }

    public void setNewEncryptedMessages(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> value) {
        this.newEncryptedMessages = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> getOtherUpdates() {
        return otherUpdates;
    }

    public void setOtherUpdates(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> value) {
        this.otherUpdates = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> value) {
        this.chats = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }

    public com.github.badoualy.telegram.tl.api.updates.TLState getState() {
        return state;
    }

    public void setState(com.github.badoualy.telegram.tl.api.updates.TLState value) {
        this.state = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.newMessages, stream);
        writeTLVector(this.newEncryptedMessages, stream);
        writeTLVector(this.otherUpdates, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLObject(this.state, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.newMessages = readTLVector(stream, context);
        this.newEncryptedMessages = readTLVector(stream, context);
        this.otherUpdates = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.state = (com.github.badoualy.telegram.tl.api.updates.TLState)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updates.difference#f49ca0";
    }

}
