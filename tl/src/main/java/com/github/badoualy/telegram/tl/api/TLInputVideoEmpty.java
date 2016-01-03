
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputVideoEmpty extends TLAbsInputVideo {
    public static final int CLASS_ID = 0x5508ec75;

    public TLInputVideoEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputVideoEmpty#5508ec75";
    }

}
