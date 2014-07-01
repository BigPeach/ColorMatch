package com.hugepeach.colormatch.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.hugepeach.colormatch.R;
import com.hugepeach.colormatch.util.Utils;

/**
 * Created by BigPeach on 6/30/14.
 */
public class Catcher extends Sprite {

    public Catcher(Context context) {
        setHeight(Utils.getScreenHeight(context)/5);
        setWidth(Utils.getBallR(context)<<1);
    }

    public void setPosition(int x,int y){
        setX(x);
        setY(y);
    }

    public boolean isCollide(Ball ball){
        int ballX = ball.getX()+ball.getR();
        int ballY = ball.getY()+ball.getR();

        if(ballY+ball.getR()<getY()){
            return false;
        }

        if(Math.sqrt(ballX - getX())*(ballX-getX()) < ball.getR()) {
            return true;
        }

        if(Math.sqrt(ballX - getX()-getWidth())*(ballX-getX()-getWidth()) < ball.getR()) {
            return true;
        }

        return false;
    }

    public void draw(Canvas canvas,Paint paint){
        paint.setColor(Color.BLUE);
        canvas.drawRect(getX(),getY(),getX()+getWidth(),getHeight()+getY(),paint);
    }
}
