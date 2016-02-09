package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;

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
public class TLAuthorization extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xff036af1;

    protected TLAbsUser user;

    public TLAuthorization() {
    }

    public TLAuthorization(TLAbsUser user) {
        this.user = user;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(user, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        user = readTLObject(stream, context, TLAbsUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += user.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "auth.authorization#ff036af1";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLAuthorization)) return false;
        if (object == this) return true;

        TLAuthorization o = (TLAuthorization) object;

        return (user == o.user || (user != null && o.user != null && user.equals(o.user)));
    }

    public TLAbsUser getUser() {
        return user;
    }

    public void setUser(TLAbsUser user) {
        this.user = user;
    }
}
