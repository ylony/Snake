package com.ylofanclub.apptest.metier;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import com.ylofanclub.apptest.modele.Drawer;

/**
 * Created by hylow on 02/02/2018.
 */

public class Square implements Element {

    private Point position;

    public Square(Point point) {
        this.position = point;
    }

    @Override
    public void updatePos(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void drawSelf(Canvas c){
        Drawer.drawElement(c, this, Color.RED);
    }

    public void eat(){
        Log.i("SNAKEGAME", "Il a mangé");
    }
}
