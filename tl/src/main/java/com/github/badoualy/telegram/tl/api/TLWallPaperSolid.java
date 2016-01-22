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
public class TLWallPaperSolid extends TLAbsWallPaper {
    public static final int CLASS_ID = 0x63117f24;

    protected int id;

    protected String title;

    protected int bgColor;

    protected int color;

    public TLWallPaperSolid() {
    }

    public TLWallPaperSolid(int id, String title, int bgColor, int color) {
        this.id = id;
        this.title = title;
        this.bgColor = bgColor;
        this.color = color;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(id, stream);
        writeTLString(title, stream);
        writeInt(bgColor, stream);
        writeInt(color, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        title = readTLString(stream);
        bgColor = readInt(stream);
        color = readInt(stream);
    }

    @Override
    public String toString() {
        return "wallPaperSolid#63117f24";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
