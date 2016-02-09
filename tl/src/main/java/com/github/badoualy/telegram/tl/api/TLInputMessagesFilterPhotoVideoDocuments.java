package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotoVideoDocuments extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0xd95e73bb;

    public TLInputMessagesFilterPhotoVideoDocuments() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterPhotoVideoDocuments#d95e73bb";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMessagesFilterPhotoVideoDocuments)) return false;
        if (object == this) return true;

        TLInputMessagesFilterPhotoVideoDocuments o = (TLInputMessagesFilterPhotoVideoDocuments) object;

        return true;
    }
}
