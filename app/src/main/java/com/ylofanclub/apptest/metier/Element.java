package com.ylofanclub.apptest.metier;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;

import com.ylofanclub.apptest.modele.Drawer;

import java.util.List;

/**
 * Created by hylow on 23/01/2018.
 */

public interface Element {
    void updatePos(Point position);
    Point getPosition();
    void drawSelf(Canvas c);
    void eat(Point position);
    List<Square> getCore();
}
