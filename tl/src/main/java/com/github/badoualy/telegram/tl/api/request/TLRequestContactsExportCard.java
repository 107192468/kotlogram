package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLMethod;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestContactsExportCard extends TLMethod<TLIntVector> {
    public static final int CONSTRUCTOR_ID = 0x84e53737;

    private final String _constructor = "contacts.exportCard#84e53737";

    public TLRequestContactsExportCard() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLIntVector deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLIntVector(stream, context);
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
        if (!(object instanceof TLRequestContactsExportCard)) return false;
        if (object == this) return true;

        TLRequestContactsExportCard o = (TLRequestContactsExportCard) object;

        return true;
    }
}
