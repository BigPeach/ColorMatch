package com.hugepeach.colormatch.util;

import android.content.Context;
import android.view.WindowManager;
import com.hugepeach.colormatch.constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by BigPeach on 14-7-1.
 */
public class Utils {
    public static final int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    public static final int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    public static final int getBallR(Context context) {
        return Utils.getScreenWidth(context) / Constants.GAME_VALUE.MAX_BALLS * 8 / 10 >> 1;
    }

    public static final int getCatcherWidth(Context context) {
        return getBallR(context) << 1;
    }

    public static final int getCatcherHeight(Context context) {
        return getScreenHeight(context) / 5;
    }

    public static final int getCatcherBuffer(Context context) {
        return (getScreenWidth(context) - getCatcherWidth(context) * Constants.GAME_VALUE.MAX_BALLS) / (Constants.GAME_VALUE.MAX_BALLS + 1);
    }

    private static Random mRandom = new Random();
    private static Map<Integer, Integer> mColorMap = null;

    public static final int getColor(int colorIndex) {
        if (mColorMap == null) {
            mColorMap = new HashMap<Integer, Integer>();
            mColorMap.put(Constants.COLORS.RED, 0xFFDD3700);
            mColorMap.put(Constants.COLORS.BLUE, 0xFF2C80C5);
            mColorMap.put(Constants.COLORS.BROWN, 0xFFC69C57);
            mColorMap.put(Constants.COLORS.GREEN, 0xFFB3FFBC);
            mColorMap.put(Constants.COLORS.YELLOW, 0xFFFFC428);
            mColorMap.put(Constants.COLORS.BACKGROUND,0xFFFFD0A2);
        }
        return mColorMap.get(colorIndex);
    }

    public static final int randomColor() {
        int num = mRandom.nextInt(5);
        return getColor(num);
    }
}
