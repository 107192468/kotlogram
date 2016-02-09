package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountUpdatePasswordSettings extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0xfa7c4b86;

    protected TLBytes currentPasswordHash;

    protected TLPasswordInputSettings newSettings;

    public TLRequestAccountUpdatePasswordSettings() {
    }

    public TLRequestAccountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) {
        this.currentPasswordHash = currentPasswordHash;
        this.newSettings = newSettings;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(currentPasswordHash, stream);
        writeTLObject(newSettings, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        currentPasswordHash = readTLBytes(stream, context);
        newSettings = readTLObject(stream, context, TLPasswordInputSettings.class, TLPasswordInputSettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(currentPasswordHash);
        size += newSettings.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "account.updatePasswordSettings#fa7c4b86";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestAccountUpdatePasswordSettings)) return false;
        if (object == this) return true;

        TLRequestAccountUpdatePasswordSettings o = (TLRequestAccountUpdatePasswordSettings) object;

        return (currentPasswordHash == o.currentPasswordHash || (currentPasswordHash != null && o.currentPasswordHash != null && currentPasswordHash.equals(o.currentPasswordHash)))
                && (newSettings == o.newSettings || (newSettings != null && o.newSettings != null && newSettings.equals(o.newSettings)));
    }

    public TLBytes getCurrentPasswordHash() {
        return currentPasswordHash;
    }

    public void setCurrentPasswordHash(TLBytes currentPasswordHash) {
        this.currentPasswordHash = currentPasswordHash;
    }

    public TLPasswordInputSettings getNewSettings() {
        return newSettings;
    }

    public void setNewSettings(TLPasswordInputSettings newSettings) {
        this.newSettings = newSettings;
    }
}
