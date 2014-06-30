package com.hugepeach.colormatch.sprite;

import android.content.res.Resources;
import com.hugepeach.colormatch.R;

/**
 * Created by bigpeach on 6/30/14.
 */
public class Ball extends Sprite {
    private int r;

    public Ball(Resources resources) {
        r = resources.getInteger(R.integer.ball_r);
    }

    public int getR() {
        return r;
    }
}
