package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLMessageGroup;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessages extends TLAbsMessages {
    public static final int CONSTRUCTOR_ID = 0xbc0f17bc;

    protected int flags;

    protected int pts;

    protected int count;

    protected TLVector<TLMessageGroup> collapsed;

    private final String _constructor = "messages.channelMessages#bc0f17bc";

    public TLChannelMessages() {
    }

    public TLChannelMessages(int pts, int count, TLVector<TLAbsMessage> messages, TLVector<TLMessageGroup> collapsed, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.pts = pts;
        this.count = count;
        this.messages = messages;
        this.collapsed = collapsed;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = collapsed != null ? (flags | 1) : (flags &~ 1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(pts, stream);
        writeInt(count, stream);
        writeTLVector(messages, stream);
        if ((flags & 1) != 0) writeTLVector(collapsed, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pts = readInt(stream);
        count = readInt(stream);
        messages = readTLVector(stream, context);
        collapsed = (flags & 1) != 0 ? readTLVector(stream, context) : null;
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += messages.computeSerializedSize();
        if ((flags & 1) != 0) size += collapsed.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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
        if (!(object instanceof TLChannelMessages)) return false;
        if (object == this) return true;

        TLChannelMessages o = (TLChannelMessages) object;

        return flags == o.flags
                && pts == o.pts
                && count == o.count
                && (messages == o.messages || (messages != null && o.messages != null && messages.equals(o.messages)))
                && (collapsed == o.collapsed || (collapsed != null && o.collapsed != null && collapsed.equals(o.collapsed)))
                && (chats == o.chats || (chats != null && o.chats != null && chats.equals(o.chats)))
                && (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<TLMessageGroup> getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(TLVector<TLMessageGroup> collapsed) {
        this.collapsed = collapsed;
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
