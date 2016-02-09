package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserProfilePhotoEmpty extends TLAbsUserProfilePhoto {
    public static final int CONSTRUCTOR_ID = 0x4f11bae1;

    public TLUserProfilePhotoEmpty() {
    }

    @Override
    public String toString() {
        return "userProfilePhotoEmpty#4f11bae1";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUserProfilePhotoEmpty)) return false;
        if (object == this) return true;

        TLUserProfilePhotoEmpty o = (TLUserProfilePhotoEmpty) object;

        return true;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
