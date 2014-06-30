package com.hugepeach.colormatch.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by BigPeach on 6/30/14.
 */
public class DrawController {
    private Context mContext;
    private Resources mResources;
    public DrawController(Context context) {
        mContext = context;
        mResources = context.getResources();
    }

    public void initImages(){

    }

    public void drawBackground(Canvas canvas,Paint paint){
        canvas.drawColor(0xFFFFD0A2);
    }
}
