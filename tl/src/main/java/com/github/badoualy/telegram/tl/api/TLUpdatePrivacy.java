package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLUpdatePrivacy extends TLAbsUpdate {
    public static final int CLASS_ID = 0xee3b272a;

    protected TLPrivacyKeyStatusTimestamp key;

    protected TLVector<TLAbsPrivacyRule> rules;

    public TLUpdatePrivacy() {
    }

    public TLUpdatePrivacy(TLPrivacyKeyStatusTimestamp key, TLVector<TLAbsPrivacyRule> rules) {
        this.key = key;
        this.rules = rules;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(key, stream);
        writeTLVector(rules, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = (com.github.badoualy.telegram.tl.api.TLPrivacyKeyStatusTimestamp) readTLObject(stream, context);
        rules = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "updatePrivacy#ee3b272a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLPrivacyKeyStatusTimestamp getKey() {
        return key;
    }

    public void setKey(TLPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }

    public TLVector<TLAbsPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<TLAbsPrivacyRule> rules) {
        this.rules = rules;
    }
}
