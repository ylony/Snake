package com.ylofanclub.apptest.modele;

import android.graphics.Canvas;

import com.ylofanclub.apptest.vue.GameView;

/**
 * Created by hylow on 25/01/2018.
 */

public class GameLoop extends Thread {
    public static int fps = 60;
    // si on veut X images en 1 seconde, soit en 1000 ms,
    // on doit en afficher une toutes les (1000 / X) ms.
    private int ticks = 1000 / this.fps;
    private GameView game;
    private boolean running;

    public GameLoop(GameView game) {
        this.game = game;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    @Override
    public void run() {
        // déclaration des temps de départ et de pause
        long startTime;
        long sleepTime;
        while (running)
        {
            // heure actuel
            startTime = System.currentTimeMillis();
            game.update();
            Canvas c = game.getHolder().lockCanvas();
            game.drawGame(c);
            game.getHolder().unlockCanvasAndPost(c);
            // Calcul du temps de pause, et pause si nécessaire
            // afin de ne réaliser le travail ci-dessus que X fois par secondes
            sleepTime = ticks-(System.currentTimeMillis() - startTime);
            try {
                if (sleepTime >= 0) {sleep(sleepTime);}
            }
            catch (Exception e) {

            }
        }
    }
}
