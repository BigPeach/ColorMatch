package com.hugepeach.colormatch.sprite;

import android.content.Context;
import android.content.res.Resources;
import com.hugepeach.colormatch.R;
import com.hugepeach.colormatch.constants.Constants;
import com.hugepeach.colormatch.util.Utils;

/**
 * Created by bigpeach on 6/30/14.
 */
public class Ball extends Sprite {
    public static final int STATE_READY = -1;
    public static final int STATE_GO = -2;
    private int mColor;
    private int mState;
    private int r;

    public Ball(Context context) {

        r = Utils.getBallR(context);
        mState = STATE_READY;
    }

    public int getR() {
        return r;
    }


    public void setState(int state) {
        this.mState = state;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public int getState() {
        return mState;
    }
}
