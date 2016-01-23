package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipant extends TLObject {
    protected int userId;

    public TLAbsChannelParticipant() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
