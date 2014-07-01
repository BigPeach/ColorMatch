package com.hugepeach.colormatch.controller;

/**
 * Created by BigPeach on 14-7-1.
 */
public class StateController {
    public static final int STATE_NOTE = 0;
    public static final int STATE_WELCOME = -1;
    public static final int STATE_GAME = -2;
    public static final int STATE_GAME_OVER = -3;

    private static StateController mController;
    private int mState;
    private StateController() {
        mState = STATE_GAME;
    }

    public static final StateController getInstance(){
        if(mController ==null){
            mController = new StateController();
        }
        return mController;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public int getState() {
        return mState;
    }
}
