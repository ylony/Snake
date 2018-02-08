package com.ylofanclub.apptest.metier;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import com.ylofanclub.apptest.modele.Drawer;

import java.util.List;

/**
 * Created by hylow on 02/02/2018.
 */

public class Square implements Element {

    private Point position;

    public Square(Point point) {
        Point position = new Point();
        position.set(point.x, point.y);
        this.position = position;
    }

    @Override
    public void updatePos(Point position) {
        Point position2 = new Point();
        position2.set(position.x, position.y);
        this.position = position2;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void drawSelf(Canvas c){
        Drawer.drawElement(c, this, Color.RED);
    }

    public void eat(Point position){
        Log.i("SNAKEGAME", "Il a mangé");
    }

    @Override
    public List<Square> getCore() {
        return null;
    }
}
