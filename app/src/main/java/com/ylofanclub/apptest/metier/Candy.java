package com.ylofanclub.apptest.metier;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;

import com.ylofanclub.apptest.modele.Drawer;

import java.util.List;

/**
 * Created by hylow on 26/01/2018.
 */

public class Candy implements Element{

    private Point position;

    public Candy(Point point) {
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
        Drawer.drawElement(c, this, Color.WHITE);
    }

    @Override
    public void eat(Point position) {

    }

    @Override
    public List<Square> getCore() {
        return null;
    }


}
