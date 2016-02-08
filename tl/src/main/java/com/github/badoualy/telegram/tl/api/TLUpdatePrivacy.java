package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdatePrivacy extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xee3b272a;

    protected TLPrivacyKeyStatusTimestamp key;

    protected TLVector<? extends TLAbsPrivacyRule> rules;

    public TLUpdatePrivacy() {
    }

    public TLUpdatePrivacy(TLPrivacyKeyStatusTimestamp key, TLVector<? extends TLAbsPrivacyRule> rules) {
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
        key = readTLObject(stream, context, TLPrivacyKeyStatusTimestamp.class, TLPrivacyKeyStatusTimestamp.CONSTRUCTOR_ID);
        rules = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += key.computeSerializedSize();
        size += rules.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updatePrivacy#ee3b272a";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLPrivacyKeyStatusTimestamp getKey() {
        return key;
    }

    public void setKey(TLPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }

    public TLVector<? extends TLAbsPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<? extends TLAbsPrivacyRule> rules) {
        this.rules = rules;
    }
}
