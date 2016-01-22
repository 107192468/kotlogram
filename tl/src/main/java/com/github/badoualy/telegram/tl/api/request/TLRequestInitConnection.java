package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestInitConnection<T extends TLObject> extends TLMethod<T> {
    public static final int CLASS_ID = 0x69796de9;

    protected int apiId;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected String langCode;

    protected TLMethod<T> query;

    public TLRequestInitConnection() {
    }

    public TLRequestInitConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) {
        this.apiId = apiId;
        this.deviceModel = deviceModel;
        this.systemVersion = systemVersion;
        this.appVersion = appVersion;
        this.langCode = langCode;
        this.query = query;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(apiId, stream);
        writeTLString(deviceModel, stream);
        writeTLString(systemVersion, stream);
        writeTLString(appVersion, stream);
        writeTLString(langCode, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        apiId = readInt(stream);
        deviceModel = readTLString(stream);
        systemVersion = readTLString(stream);
        appVersion = readTLString(stream);
        langCode = readTLString(stream);
        query = readTLMethod(stream, context);
    }

    @Override
    public String toString() {
        return "initConnection#69796de9";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
