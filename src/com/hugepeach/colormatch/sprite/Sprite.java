package com.hugepeach.colormatch.sprite;

/**
 * Created by BigPeach on 6/30/14.
 */
public class Sprite {
    private int x;
    private int y;
    private int width;
    private int height;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isCollide(Sprite sprite) {

        if (    // is the bottom b above the top of a?
                sprite.getY() + sprite.getHeight() < y ||
                // is the top of b below bottom of a?
                sprite.getY() > y + height ||
                // is the right of b to the left of a?
                sprite.getX() + sprite.getWidth() < x ||
                // is the left of b to the right of a?
                sprite.getX() > x + width){
            return false;
        }
        return true;
    }
}
