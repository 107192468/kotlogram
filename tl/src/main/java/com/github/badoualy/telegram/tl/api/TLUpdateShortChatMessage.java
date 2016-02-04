package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateShortChatMessage extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0x248afa62;

    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected int id;

    protected int fromId;

    protected int chatId;

    protected String message;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected TLAbsPeer fwdFromId;

    protected Integer fwdDate;

    protected Integer viaBotId;

    protected Integer replyToMsgId;

    protected TLVector<TLAbsMessageEntity> entities;

    public TLUpdateShortChatMessage() {
    }

    public TLUpdateShortChatMessage(boolean unread, boolean out, boolean mentioned, boolean mediaUnread, int id, int fromId, int chatId, String message, int pts, int ptsCount, int date, TLAbsPeer fwdFromId, Integer fwdDate, Integer viaBotId, Integer replyToMsgId, TLVector<TLAbsMessageEntity> entities) {
        this.unread = unread;
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.id = id;
        this.fromId = fromId;
        this.chatId = chatId;
        this.message = message;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
        this.fwdFromId = fwdFromId;
        this.fwdDate = fwdDate;
        this.viaBotId = viaBotId;
        this.replyToMsgId = replyToMsgId;
        this.entities = entities;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);
        flags = mentioned ? (flags | 16) : (flags &~ 16);
        flags = mediaUnread ? (flags | 32) : (flags &~ 32);
        flags = fwdFromId != null ? (flags | 4) : (flags &~ 4);
        flags = fwdDate != null ? (flags | 4) : (flags &~ 4);
        flags = viaBotId != null ? (flags | 2048) : (flags &~ 2048);
        flags = replyToMsgId != null ? (flags | 8) : (flags &~ 8);
        flags = entities != null ? (flags | 128) : (flags &~ 128);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(unread, stream);
        if ((flags & 2) != 0) writeBoolean(out, stream);
        if ((flags & 16) != 0) writeBoolean(mentioned, stream);
        if ((flags & 32) != 0) writeBoolean(mediaUnread, stream);
        writeInt(id, stream);
        writeInt(fromId, stream);
        writeInt(chatId, stream);
        writeString(message, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        writeInt(date, stream);
        if ((flags & 4) != 0) writeTLObject(fwdFromId, stream);
        if ((flags & 4) != 0) writeInt(fwdDate, stream);
        if ((flags & 2048) != 0) writeInt(viaBotId, stream);
        if ((flags & 8) != 0) writeInt(replyToMsgId, stream);
        if ((flags & 128) != 0) writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        unread = (flags & 1) != 0;
        out = (flags & 2) != 0;
        mentioned = (flags & 16) != 0;
        mediaUnread = (flags & 32) != 0;
        id = readInt(stream);
        fromId = readInt(stream);
        chatId = readInt(stream);
        message = readTLString(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
        date = readInt(stream);
        if ((flags & 4) != 0) fwdFromId = (com.github.badoualy.telegram.tl.api.TLAbsPeer) readTLObject(stream, context);
        if ((flags & 4) != 0) fwdDate = readInt(stream);
        if ((flags & 2048) != 0) viaBotId = readInt(stream);
        if ((flags & 8) != 0) replyToMsgId = readInt(stream);
        if ((flags & 128) != 0) entities = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "updateShortChatMessage#248afa62";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public boolean getOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public boolean getMentioned() {
        return mentioned;
    }

    public void setMentioned(boolean mentioned) {
        this.mentioned = mentioned;
    }

    public boolean getMediaUnread() {
        return mediaUnread;
    }

    public void setMediaUnread(boolean mediaUnread) {
        this.mediaUnread = mediaUnread;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsPeer getFwdFromId() {
        return fwdFromId;
    }

    public void setFwdFromId(TLAbsPeer fwdFromId) {
        this.fwdFromId = fwdFromId;
    }

    public Integer getFwdDate() {
        return fwdDate;
    }

    public void setFwdDate(Integer fwdDate) {
        this.fwdDate = fwdDate;
    }

    public Integer getViaBotId() {
        return viaBotId;
    }

    public void setViaBotId(Integer viaBotId) {
        this.viaBotId = viaBotId;
    }

    public Integer getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(Integer replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
