package com.hugepeach.colormatch.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
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
        int buffer = Utils.getCatcherBuffer(mContext);
        Log.i(TAG,"BUFFER = "+buffer);
        int x = buffer;
        int index = 0;
        while(x < width+Utils.getCatcherWidth(mContext)){
            Catcher catcher = new Catcher(mContext,x);
            catcher.setColor(Utils.getColor(index++));
            index %= Constants.GAME_VALUE.MAX_BALLS;
            x += catcher.getWidth()+buffer;
            mListCatcher.add(catcher);
        }
//        Catcher catcher = new Catcher(mContext,x);
//        mListCatcher.add(catcher);
        Log.i(TAG,"list size = "+mListCatcher.size());
    }

    public void initImages(){

    }

    public void moveCatcher(int x){
        for(Catcher catcher:mListCatcher){
            catcher.setPosition(x);
        }
    }

    public void resetBasicCatcher(){
        for(Catcher catcher:mListCatcher){
            catcher.resetBasicX();
        }
    }

    public void drawBackground(Canvas canvas,Paint paint){
        canvas.drawColor(Utils.getColor(Constants.COLORS.BACKGROUND));
    }

    public void drawCatcher(Canvas canvas,Paint paint){
        for(Catcher catcher:mListCatcher){
            catcher.draw(canvas,paint);
        }
    }
}
