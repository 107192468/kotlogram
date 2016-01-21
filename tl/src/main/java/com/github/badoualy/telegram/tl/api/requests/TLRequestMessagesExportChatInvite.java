
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestMessagesExportChatInvite extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite> {

    public static final int CLASS_ID = 0x7d885289;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesExportChatInvite(        int _chatId) {
        this.chatId = _chatId;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite) {
            return (com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int chatId;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.exportChatInvite#7d885289";
    }

}
