package com.ylofanclub.apptest.modele;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;

import com.ylofanclub.apptest.metier.Element;

/**
 * Created by hylow on 24/01/2018.
 */

public class Drawer {

    public static Point size;
    public static int blockSize;
    public static int nbBlockHigh;

    public static void drawInterface(Canvas canvas){
        Paint paint = new Paint();
        paint.setTextSize((float)(blockSize * 1.3));
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        canvas.drawText("Snake Game", (float)(size.x / 3.1), (float)(blockSize * 1.2), paint);
    }

    public static void drawElement(Canvas c, Element s, int color){
        Paint redPaint = new Paint();
        redPaint.setColor(color);
        redPaint.setAntiAlias(true);
        c.drawCircle(s.getPosition().x,s.getPosition().y, Drawer.blockSize / 2, redPaint);
    }
}
