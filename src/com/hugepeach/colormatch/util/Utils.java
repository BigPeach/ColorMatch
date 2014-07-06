package com.hugepeach.colormatch.util;

import android.content.Context;
import android.view.WindowManager;
import com.hugepeach.colormatch.constants.Constants;

/**
 * Created by BigPeach on 14-7-1.
 */
public class Utils {
    public static final int getScreenHeight(Context context){
        WindowManager wm =(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    public static final int getScreenWidth(Context context){
        WindowManager wm =(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    public static final int getBallR(Context context){
        return Utils.getScreenWidth(context)/ Constants.GAME_VALUE.MAX_BALLS * 8/10 >> 1;
    }

    public static final int getCatcherWidth(Context context){
        return getBallR(context)<<1;
    }

    public static final int getCatcherBuffer(Context context){
        return (getScreenWidth(context) - getCatcherWidth(context) * Constants.GAME_VALUE.MAX_BALLS)/(Constants.GAME_VALUE.MAX_BALLS+1);
    }
}
