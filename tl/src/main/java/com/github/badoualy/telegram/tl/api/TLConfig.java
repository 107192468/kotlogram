package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLConfig extends TLObject {
    public static final int CLASS_ID = 0x6bbc5f8;

    protected int date;

    protected int expires;

    protected boolean testMode;

    protected int thisDc;

    protected TLVector<TLDcOption> dcOptions;

    protected int chatSizeMax;

    protected int megagroupSizeMax;

    protected int forwardedCountMax;

    protected int onlineUpdatePeriodMs;

    protected int offlineBlurTimeoutMs;

    protected int offlineIdleTimeoutMs;

    protected int onlineCloudTimeoutMs;

    protected int notifyCloudDelayMs;

    protected int notifyDefaultDelayMs;

    protected int chatBigSize;

    protected int pushChatPeriodMs;

    protected int pushChatLimit;

    protected int savedGifsLimit;

    protected TLVector<TLDisabledFeature> disabledFeatures;

    public TLConfig() {
    }

    public TLConfig(int date, int expires, boolean testMode, int thisDc, TLVector<TLDcOption> dcOptions, int chatSizeMax, int megagroupSizeMax, int forwardedCountMax, int onlineUpdatePeriodMs, int offlineBlurTimeoutMs, int offlineIdleTimeoutMs, int onlineCloudTimeoutMs, int notifyCloudDelayMs, int notifyDefaultDelayMs, int chatBigSize, int pushChatPeriodMs, int pushChatLimit, int savedGifsLimit, TLVector<TLDisabledFeature> disabledFeatures) {
        this.date = date;
        this.expires = expires;
        this.testMode = testMode;
        this.thisDc = thisDc;
        this.dcOptions = dcOptions;
        this.chatSizeMax = chatSizeMax;
        this.megagroupSizeMax = megagroupSizeMax;
        this.forwardedCountMax = forwardedCountMax;
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs;
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs;
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs;
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs;
        this.notifyCloudDelayMs = notifyCloudDelayMs;
        this.notifyDefaultDelayMs = notifyDefaultDelayMs;
        this.chatBigSize = chatBigSize;
        this.pushChatPeriodMs = pushChatPeriodMs;
        this.pushChatLimit = pushChatLimit;
        this.savedGifsLimit = savedGifsLimit;
        this.disabledFeatures = disabledFeatures;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(date, stream);
        writeInt(expires, stream);
        writeTLBool(testMode, stream);
        writeInt(thisDc, stream);
        writeTLVector(dcOptions, stream);
        writeInt(chatSizeMax, stream);
        writeInt(megagroupSizeMax, stream);
        writeInt(forwardedCountMax, stream);
        writeInt(onlineUpdatePeriodMs, stream);
        writeInt(offlineBlurTimeoutMs, stream);
        writeInt(offlineIdleTimeoutMs, stream);
        writeInt(onlineCloudTimeoutMs, stream);
        writeInt(notifyCloudDelayMs, stream);
        writeInt(notifyDefaultDelayMs, stream);
        writeInt(chatBigSize, stream);
        writeInt(pushChatPeriodMs, stream);
        writeInt(pushChatLimit, stream);
        writeInt(savedGifsLimit, stream);
        writeTLVector(disabledFeatures, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        date = readInt(stream);
        expires = readInt(stream);
        testMode = readTLBool(stream);
        thisDc = readInt(stream);
        dcOptions = readTLVector(stream, context);
        chatSizeMax = readInt(stream);
        megagroupSizeMax = readInt(stream);
        forwardedCountMax = readInt(stream);
        onlineUpdatePeriodMs = readInt(stream);
        offlineBlurTimeoutMs = readInt(stream);
        offlineIdleTimeoutMs = readInt(stream);
        onlineCloudTimeoutMs = readInt(stream);
        notifyCloudDelayMs = readInt(stream);
        notifyDefaultDelayMs = readInt(stream);
        chatBigSize = readInt(stream);
        pushChatPeriodMs = readInt(stream);
        pushChatLimit = readInt(stream);
        savedGifsLimit = readInt(stream);
        disabledFeatures = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "config#6bbc5f8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int thisDc) {
        this.thisDc = thisDc;
    }

    public TLVector<TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }

    public int getChatSizeMax() {
        return chatSizeMax;
    }

    public void setChatSizeMax(int chatSizeMax) {
        this.chatSizeMax = chatSizeMax;
    }

    public int getMegagroupSizeMax() {
        return megagroupSizeMax;
    }

    public void setMegagroupSizeMax(int megagroupSizeMax) {
        this.megagroupSizeMax = megagroupSizeMax;
    }

    public int getForwardedCountMax() {
        return forwardedCountMax;
    }

    public void setForwardedCountMax(int forwardedCountMax) {
        this.forwardedCountMax = forwardedCountMax;
    }

    public int getOnlineUpdatePeriodMs() {
        return onlineUpdatePeriodMs;
    }

    public void setOnlineUpdatePeriodMs(int onlineUpdatePeriodMs) {
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs;
    }

    public int getOfflineBlurTimeoutMs() {
        return offlineBlurTimeoutMs;
    }

    public void setOfflineBlurTimeoutMs(int offlineBlurTimeoutMs) {
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs;
    }

    public int getOfflineIdleTimeoutMs() {
        return offlineIdleTimeoutMs;
    }

    public void setOfflineIdleTimeoutMs(int offlineIdleTimeoutMs) {
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs;
    }

    public int getOnlineCloudTimeoutMs() {
        return onlineCloudTimeoutMs;
    }

    public void setOnlineCloudTimeoutMs(int onlineCloudTimeoutMs) {
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs;
    }

    public int getNotifyCloudDelayMs() {
        return notifyCloudDelayMs;
    }

    public void setNotifyCloudDelayMs(int notifyCloudDelayMs) {
        this.notifyCloudDelayMs = notifyCloudDelayMs;
    }

    public int getNotifyDefaultDelayMs() {
        return notifyDefaultDelayMs;
    }

    public void setNotifyDefaultDelayMs(int notifyDefaultDelayMs) {
        this.notifyDefaultDelayMs = notifyDefaultDelayMs;
    }

    public int getChatBigSize() {
        return chatBigSize;
    }

    public void setChatBigSize(int chatBigSize) {
        this.chatBigSize = chatBigSize;
    }

    public int getPushChatPeriodMs() {
        return pushChatPeriodMs;
    }

    public void setPushChatPeriodMs(int pushChatPeriodMs) {
        this.pushChatPeriodMs = pushChatPeriodMs;
    }

    public int getPushChatLimit() {
        return pushChatLimit;
    }

    public void setPushChatLimit(int pushChatLimit) {
        this.pushChatLimit = pushChatLimit;
    }

    public int getSavedGifsLimit() {
        return savedGifsLimit;
    }

    public void setSavedGifsLimit(int savedGifsLimit) {
        this.savedGifsLimit = savedGifsLimit;
    }

    public TLVector<TLDisabledFeature> getDisabledFeatures() {
        return disabledFeatures;
    }

    public void setDisabledFeatures(TLVector<TLDisabledFeature> disabledFeatures) {
        this.disabledFeatures = disabledFeatures;
    }
}
