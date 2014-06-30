package com.hugepeach.colormatch.sprite;

import android.content.res.Resources;
import com.hugepeach.colormatch.R;

/**
 * Created by BigPeach on 6/30/14.
 */
public class Catcher extends Sprite {

    public Catcher(Resources resources) {
        setHeight(resources.getInteger(R.integer.catcher_height));
        setWidth(resources.getInteger(R.integer.ball_r)<<1);
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
}
