package com.hugepeach.colormatch.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.hugepeach.colormatch.R;
import com.hugepeach.colormatch.constants.Constants;
import com.hugepeach.colormatch.sprite.Ball;
import com.hugepeach.colormatch.sprite.Catcher;
import com.hugepeach.colormatch.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigPeach on 6/30/14.
 */
public class DrawController {
    private static final String TAG = "DrawController";
    private Context mContext;
    private Resources mResources;
    private List<Ball> mListBall;
    private List<Catcher> mListCatcher;
    public DrawController(Context context) {
        mContext = context;
        mResources = context.getResources();
    }

    public void initRes(){
        initBall();
        initCatcher();
    }

    private void initBall(){
        mListBall = new ArrayList<Ball>();

    }

    private void initCatcher(){
        mListCatcher = new ArrayList<Catcher>();
        int width = Utils.getScreenWidth(mContext);
        int height = Utils.getScreenHeight(mContext);
        int buffer = Utils.getCatcherBuffer(mContext);
        Log.i(TAG,"BUFFER = "+buffer);
        int x = buffer;
        while(x < width){
            Catcher catcher = new Catcher(mContext);
            catcher.setPosition(x,height - catcher.getHeight());
            x += catcher.getWidth()+buffer;
            mListCatcher.add(catcher);
        }
        Log.i(TAG,"list size = "+mListCatcher.size());
    }

    public void initImages(){

    }

    public void drawBackground(Canvas canvas,Paint paint){
        canvas.drawColor(0xFFFFD0A2);
    }

    public void drawCatcher(Canvas canvas,Paint paint){
        for(Catcher catcher:mListCatcher){
            catcher.draw(canvas,paint);
        }
    }
}
