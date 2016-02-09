package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLAbsPassword;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountGetPassword extends TLMethod<TLAbsPassword> {
    public static final int CONSTRUCTOR_ID = 0x548a30f5;

    public TLRequestAccountGetPassword() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsPassword deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsPassword)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsPassword) response;
    }

    @Override
    public String toString() {
        return "account.getPassword#548a30f5";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestAccountGetPassword)) return false;
        if (object == this) return true;

        TLRequestAccountGetPassword o = (TLRequestAccountGetPassword) object;

        return true;
    }
}
