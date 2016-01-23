package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop;
import com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestPhotosUpdateProfilePhoto extends TLMethod<TLAbsUserProfilePhoto> {
    public static final int CLASS_ID = 0xeef579a0;

    protected TLAbsInputPhoto id;

    protected TLAbsInputPhotoCrop crop;

    public TLRequestPhotosUpdateProfilePhoto() {
    }

    public TLRequestPhotosUpdateProfilePhoto(TLAbsInputPhoto id, TLAbsInputPhotoCrop crop) {
        this.id = id;
        this.crop = crop;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUserProfilePhoto deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUserProfilePhoto)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUserProfilePhoto) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
        writeTLObject(crop, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = (com.github.badoualy.telegram.tl.api.TLAbsInputPhoto) readTLObject(stream, context);
        crop = (com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "photos.updateProfilePhoto#eef579a0";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(TLAbsInputPhoto id) {
        this.id = id;
    }

    public TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(TLAbsInputPhotoCrop crop) {
        this.crop = crop;
    }
}
