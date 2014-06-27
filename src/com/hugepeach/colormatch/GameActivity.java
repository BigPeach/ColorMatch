package com.hugepeach.colormatch;

import android.app.Activity;
import android.os.Bundle;
import com.hugepeach.colormatch.com.hugepeach.colormatch.view.GameView;

public class GameActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView view = new GameView(this,null);
        setContentView(view);

    }
}
