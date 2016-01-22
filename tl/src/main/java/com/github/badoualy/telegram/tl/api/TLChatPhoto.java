package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatPhoto extends TLAbsChatPhoto {
    public static final int CLASS_ID = 0x6153276a;

    protected TLAbsFileLocation photoSmall;

    protected TLAbsFileLocation photoBig;

    public TLChatPhoto() {
    }

    public TLChatPhoto(TLAbsFileLocation photoSmall, TLAbsFileLocation photoBig) {
        this.photoSmall = photoSmall;
        this.photoBig = photoBig;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(photoSmall, stream);
        writeTLObject(photoBig, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        photoSmall = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation) readTLObject(stream, context);
        photoBig = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "chatPhoto#6153276a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsFileLocation getPhotoSmall() {
        return photoSmall;
    }

    public void setPhotoSmall(TLAbsFileLocation photoSmall) {
        this.photoSmall = photoSmall;
    }

    public TLAbsFileLocation getPhotoBig() {
        return photoBig;
    }

    public void setPhotoBig(TLAbsFileLocation photoBig) {
        this.photoBig = photoBig;
    }
}
