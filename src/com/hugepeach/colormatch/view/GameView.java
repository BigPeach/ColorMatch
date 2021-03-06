package com.hugepeach.colormatch.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.hugepeach.colormatch.controller.DrawController;


/**
 * Created by BigPeach on 14-6-27.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "GameView";
    private static final int MAX_FRAME = 30;//30FPS
    private static final int BUFFER_TIME = 1000 / MAX_FRAME;
    private static final int REFRESH_VIEW = -1;
    private SurfaceHolder mHolder;
    private Paint mPaint;
    private Resources mResources;
    private DrawController mDrawController;
    private Context mContext;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        mResources = getResources();
        mPaint = new Paint();
        mHolder = getHolder();
        mHolder.addCallback(this);
        mDrawController = new DrawController(mContext);
        mDrawController.initRes();
    }
    private int mStartX;
    private int mBufferX;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mStartX = (int)event.getX();
                return true;
            case MotionEvent.ACTION_MOVE:
                mBufferX = (int)event.getX()-mStartX;
                Log.i(TAG,"mBuffer = "+mBufferX);
                mDrawController.moveCatcher(mBufferX);
                return true;
            case MotionEvent.ACTION_UP:
                mDrawController.resetBasicCatcher();
                mBufferX = 0;
                return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mHandler.sendEmptyMessage(REFRESH_VIEW);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_VIEW:
                    drawView();
                    break;
            }
        }
    };

    private void drawView() {
        long startTime = System.currentTimeMillis();
        synchronized (mHolder) {
            Canvas canvas = mHolder.lockCanvas();
            if (canvas == null) {
                return;
            }
            drawGame(canvas,mPaint);
            mHolder.unlockCanvasAndPost(canvas);
        }
        long time = System.currentTimeMillis() - startTime;
        if (BUFFER_TIME - time > 0) {
            mHandler.sendEmptyMessageDelayed(REFRESH_VIEW, BUFFER_TIME - time);
        } else {
            mHandler.sendEmptyMessage(REFRESH_VIEW);
        }
        postInvalidate();
    }

    private void drawGame(Canvas canvas, Paint paint) {
        mDrawController.drawBackground(canvas,paint);
        mDrawController.drawCatcher(canvas,paint);
    }


}
