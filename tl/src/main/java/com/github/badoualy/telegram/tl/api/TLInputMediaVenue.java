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
public class TLInputMediaVenue extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x2827a81a;

    protected TLAbsInputGeoPoint geoPoint;

    protected String title;

    protected String address;

    protected String provider;

    protected String venueId;

    public TLInputMediaVenue() {
    }

    public TLInputMediaVenue(TLAbsInputGeoPoint geoPoint, String title, String address, String provider, String venueId) {
        this.geoPoint = geoPoint;
        this.title = title;
        this.address = address;
        this.provider = provider;
        this.venueId = venueId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geoPoint, stream);
        writeTLString(title, stream);
        writeTLString(address, stream);
        writeTLString(provider, stream);
        writeTLString(venueId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geoPoint = (com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint) readTLObject(stream, context);
        title = readTLString(stream);
        address = readTLString(stream);
        provider = readTLString(stream);
        venueId = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaVenue#2827a81a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(TLAbsInputGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }
}
