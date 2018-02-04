package com.ylofanclub.apptest.metier;

import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by hylow on 02/02/2018.
 */

public class Snake implements Element {
    private Point position;

    public Snake(Point point) {
        this.position = point;
    }

    @Override
    public void updatePos(Point position) {

    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void drawSelf(Canvas c) {

    }

    @Override
    public void eat() {

    }
}
