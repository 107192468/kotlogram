package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLKeyboardButtonRow extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x77608b83;

    protected TLVector<? extends TLKeyboardButton> buttons;

    public TLKeyboardButtonRow() {
    }

    public TLKeyboardButtonRow(TLVector<? extends TLKeyboardButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(buttons, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        buttons = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += buttons.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "keyboardButtonRow#77608b83";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLKeyboardButtonRow)) return false;
        if (object == this) return true;

        TLKeyboardButtonRow o = (TLKeyboardButtonRow) object;

        return (buttons == o.buttons || (buttons != null && o.buttons != null && buttons.equals(o.buttons)));
    }

    public TLVector<? extends TLKeyboardButton> getButtons() {
        return buttons;
    }

    public void setButtons(TLVector<? extends TLKeyboardButton> buttons) {
        this.buttons = buttons;
    }
}
