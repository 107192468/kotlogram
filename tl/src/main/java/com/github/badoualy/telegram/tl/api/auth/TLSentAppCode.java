package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSentAppCode extends TLAbsSentCode {
    public static final int CONSTRUCTOR_ID = 0xe325edcf;

    public TLSentAppCode() {
    }

    public TLSentAppCode(boolean phoneRegistered, String phoneCodeHash, int sendCallTimeout, boolean isPassword) {
        this.phoneRegistered = phoneRegistered;
        this.phoneCodeHash = phoneCodeHash;
        this.sendCallTimeout = sendCallTimeout;
        this.isPassword = isPassword;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeBoolean(phoneRegistered, stream);
        writeString(phoneCodeHash, stream);
        writeInt(sendCallTimeout, stream);
        writeBoolean(isPassword, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneRegistered = readTLBool(stream);
        phoneCodeHash = readTLString(stream);
        sendCallTimeout = readInt(stream);
        isPassword = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "auth.sentAppCode#e325edcf";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String phoneCodeHash) {
        this.phoneCodeHash = phoneCodeHash;
    }

    public int getSendCallTimeout() {
        return sendCallTimeout;
    }

    public void setSendCallTimeout(int sendCallTimeout) {
        this.sendCallTimeout = sendCallTimeout;
    }

    public boolean getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(boolean isPassword) {
        this.isPassword = isPassword;
    }
}
