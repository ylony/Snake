package com.ylofanclub.apptest.vue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.ylofanclub.apptest.modele.Drawer;
import com.ylofanclub.apptest.modele.GameEngine;
import com.ylofanclub.apptest.modele.GameLoop;

/**
 * Created by hylow on 24/01/2018.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback,GestureDetector.OnGestureListener{
    private SurfaceHolder holder;
    private boolean running = true;
    public GameEngine engine;
    private GestureDetectorCompat mDetector;
    private GameLoop loop;
    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);
        holder = this.getHolder();
        this.engine = new GameEngine(this);
        mDetector = new GestureDetectorCompat(getContext(), this);
        loop  = new GameLoop(this);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        loop.setRunning(true);
        loop.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        }


    public void update(){
        engine.updateGame();
    }

    public void drawGame(Canvas c){
        c.drawColor(Color.argb(255, 120, 197, 87)); // background
        engine.getSnake().drawSelf(c);
        engine.getCandy().drawSelf(c);
        Drawer.drawInterface(c);
        Drawer.drawLimit(c);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        engine = new GameEngine(this);
        loop.setRunning(true);
        loop.start();
        Log.i("MONSNAKE", "longpress");
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // TODO Auto-generated method stub
        return mDetector.onTouchEvent(motionEvent);
    }


    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getY() - motionEvent2.getY() > 85) {
            if(GameEngine.move != GameEngine.Direction.DOWN) {
                GameEngine.move = GameEngine.Direction.UP;
            }
            return true;
        }

        if (motionEvent2.getY() - motionEvent1.getY() > 85) {
            if(GameEngine.move != GameEngine.Direction.UP) {
                GameEngine.move = GameEngine.Direction.DOWN;
            }
            return true;
        }

        if (motionEvent1.getX() - motionEvent2.getX() > 85) {
            if(GameEngine.move != GameEngine.Direction.RIGHT) {
                GameEngine.move = GameEngine.Direction.LEFT;
            }
            return true;
        }

        if (motionEvent2.getX() - motionEvent1.getX() > 85) {
            if(GameEngine.move != GameEngine.Direction.LEFT) {
                GameEngine.move = GameEngine.Direction.RIGHT;
            }
            return true;
        } else {
            return true;
        }
    }

    public void stop() {
        loop.setRunning(false);
        loop.interrupt();
    }
}
