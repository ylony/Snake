package com.ylofanclub.apptest.metier;

import android.graphics.Canvas;
import android.graphics.Point;

import com.ylofanclub.apptest.modele.Drawer;
import com.ylofanclub.apptest.modele.GameEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hylow on 02/02/2018.
 */

public class Snake implements Element {
    private Point position;
    private List<Square> tail;

    public Snake(Point point) {
        this.tail = new ArrayList<>();
        Point position = new Point();
        position.set(point.x, point.y);
        this.tail.add(new Square(position));
    }

    @Override
    public void updatePos(Point position) {
        Integer i = 0;
        Integer nbTrail = this.tail.size();
        while (i < nbTrail)
        {
            if(i + 1 == nbTrail)
            {
                Square one = this.tail.get(i);
                one.updatePos(position);
            }
            else
            {
                Square one = this.tail.get(i);
                Square two = this.tail.get(i + 1);
                one.updatePos(two.getPosition());
                two.updatePos(position);
            }
            i++;
        }
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void drawSelf(Canvas c) {
        Integer i = 0;
        Square square = null;
        while(i < this.tail.size()){
            square = this.tail.get(i);
            square.drawSelf(c);
            //Log.i("MONSNAKE", square.getPosition().toString() + i.toString());
            i++;
        }
        //Integer e = this.tail.size();
        //Log.i("MONSNAKE", e.toString());
    }

    @Override
    public void eat(Point position) {
        this.tail.add(new Square(position));
    }

    public List<Square> getCore(){
        return this.tail;
    }
}
