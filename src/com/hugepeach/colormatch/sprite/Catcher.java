package com.hugepeach.colormatch.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.hugepeach.colormatch.R;
import com.hugepeach.colormatch.util.Utils;

/**
 * Created by BigPeach on 6/30/14.
 */
public class Catcher extends Sprite {
    private static final String TAG = "Catcher";
    private int mBasicX = 0;
    private int mScreenWidth;
    private int mColor;
    private Context mContext;
    public Catcher(Context context, int x) {
        mContext = context;
        setHeight(Utils.getScreenHeight(context) / 5);
        setWidth(Utils.getCatcherWidth(context));
        mScreenWidth = Utils.getScreenWidth(context);
        mBasicX = x;
        setY(Utils.getScreenHeight(context) - getHeight());
        setX(x);
    }

    public void setPosition(int x) {
        if (mBasicX + x < -getWidth()) {
            setX(mBasicX + x + mScreenWidth+Utils.getCatcherWidth(mContext));
        } else if (mBasicX + x > mScreenWidth) {
            setX(mBasicX + x - mScreenWidth - getWidth());
        } else {
            setX(mBasicX + x);
        }
    }

    public void resetBasicX() {
        mBasicX = getX();
    }

    public boolean isCollide(Ball ball) {
        int ballX = ball.getX() + ball.getR();
        int ballY = ball.getY() + ball.getR();

        if (ballY + ball.getR() < getY()) {
            return false;
        }

        if (Math.sqrt(ballX - getX()) * (ballX - getX()) < ball.getR()) {
            return true;
        }

        if (Math.sqrt(ballX - getX() - getWidth()) * (ballX - getX() - getWidth()) < ball.getR()) {
            return true;
        }

        return false;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(getColor());
        canvas.drawRect(getX(), getY(), getX() + getWidth(), getHeight() + getY(), paint);
    }

    public void setColor(int color) {
        this.mColor = color;
        Log.i(TAG,"COLOR = "+color);
    }

    public int getColor() {
        return mColor;
    }
}
