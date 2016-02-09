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
public class TLChatInviteAlready extends TLAbsChatInvite {
    public static final int CONSTRUCTOR_ID = 0x5a686d7c;

    protected TLAbsChat chat;

    public TLChatInviteAlready() {
    }

    public TLChatInviteAlready(TLAbsChat chat) {
        this.chat = chat;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(chat, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chat = readTLObject(stream, context, TLAbsChat.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += chat.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "chatInviteAlready#5a686d7c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChatInviteAlready)) return false;
        if (object == this) return true;

        TLChatInviteAlready o = (TLChatInviteAlready) object;

        return (chat == o.chat || (chat != null && o.chat != null && chat.equals(o.chat)));
    }

    public TLAbsChat getChat() {
        return chat;
    }

    public void setChat(TLAbsChat chat) {
        this.chat = chat;
    }
}
