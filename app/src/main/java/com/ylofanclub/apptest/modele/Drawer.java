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
        canvas.drawText("Snake Game", (float)(size.x / 3.1), (float)(blockSize * 1.8), paint);
        if(GameEngine.player != null) {
            canvas.drawText(GameEngine.player.getNbPts().toString(), (float) (size.x / 2.1), (float) (size.y / 2), paint);
        }
    }

    public static void drawElement(Canvas c, Element s, int color){
        Paint redPaint = new Paint();
        redPaint.setColor(color);
        redPaint.setAntiAlias(true);
        c.drawCircle(s.getPosition().x,s.getPosition().y, Drawer.blockSize / 2, redPaint);
    }

    public static void drawLimit(Canvas c){
        Paint redPaint = new Paint();
        redPaint.setColor(Color.BLACK);
        redPaint.setAntiAlias(true);
        for(int i = 0; i <= Drawer.size.x; i += Drawer.blockSize){
            c.drawCircle(i, 0, Drawer.blockSize / 2, redPaint);
        }
        for(int i = 0; i <= Drawer.size.x; i += Drawer.blockSize){
            c.drawCircle(i, Drawer.size.y, Drawer.blockSize / 2, redPaint);
        }
        for(int i = 0; i <= Drawer.size.y; i += Drawer.blockSize){
            c.drawCircle(0, i, Drawer.blockSize / 2, redPaint);
        }
        for(int i = 0; i <= Drawer.size.y; i += Drawer.blockSize){
            c.drawCircle(Drawer.size.x, i, Drawer.blockSize / 2, redPaint);
        }
    }
}
