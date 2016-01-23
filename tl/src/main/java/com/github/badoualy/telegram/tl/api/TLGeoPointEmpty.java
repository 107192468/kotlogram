package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGeoPointEmpty extends TLAbsGeoPoint {
    public static final int CLASS_ID = 0x1117dd5f;

    public TLGeoPointEmpty() {
    }

    @Override
    public String toString() {
        return "geoPointEmpty#1117dd5f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
