package com.ylofanclub.apptest.vue;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

import com.ylofanclub.apptest.modele.Drawer;
import com.ylofanclub.apptest.modele.GameEngine;

/**
 * Created by hylow on 24/01/2018.
 */

public class MainWindow extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Drawer.size = size;
        Drawer.blockSize = size.x / 20;
        Drawer.nbBlockHigh = size.y / Drawer.blockSize;
        GameView game = new GameView(getApplicationContext());
        setContentView(game);
    }
}
