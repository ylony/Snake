package com.ylofanclub.apptest.modele;

import android.graphics.Point;
import android.util.Log;

import com.ylofanclub.apptest.metier.Candy;
import com.ylofanclub.apptest.metier.Element;
import com.ylofanclub.apptest.metier.Player;
import com.ylofanclub.apptest.metier.Snake;
import com.ylofanclub.apptest.metier.Square;
import com.ylofanclub.apptest.vue.GameView;

import java.util.Random;

/**
 * Created by hylow on 25/01/2018.
 */

public class GameEngine {
    private GameView game;
    private Element snake;
    private Element candy;
    public enum Direction
    {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static Direction move;
    private Point CurrentPos = new Point();
    public static Player player;


    public GameEngine(GameView game) {
        this.game = game;
        CurrentPos.x = ((Drawer.size.x / 2) / Drawer.blockSize) * Drawer.blockSize;
        CurrentPos.y = ((Drawer.size.y / 2) / Drawer.blockSize) * Drawer.blockSize;
        snake = new Snake(CurrentPos);
        Point rand = new Point();
        candy = new Candy(rand);
        generateNewCandyPos();
        move = Direction.RIGHT;
        player =  new Player("Ylony");
    }
    public void generateNewCandyPos(){
        Random rand = new Random();
        Integer x = ((rand.nextInt(Drawer.size.x - Drawer.blockSize) + Drawer.blockSize) / Drawer.blockSize) * Drawer.blockSize;
        Integer y = ((rand.nextInt(Drawer.size.y - Drawer.blockSize ) + Drawer.blockSize) / Drawer.blockSize) * Drawer.blockSize;
        candy.updatePos(new Point(x, y));
        for(Square sq : this.getSnake().getCore()){
            if(sq.getPosition().x == x && sq.getPosition().y == y){
                generateNewCandyPos();
            }
        }
    }
    public void updateGame(){
        if(!checkPos()){ // Check si le joueur a perdu
            game.stop();
            Log.i("MONSNAKE", "perdu");
        }
        if(CurrentPos.x == candy.getPosition().x && CurrentPos.y == candy.getPosition().y){
            generateNewCandyPos();
            snake.eat(CurrentPos);
            player.addPts();
        }
        if(move == Direction.DOWN)
        {
            CurrentPos.y += Drawer.blockSize;
        }
        if (move == Direction.UP)
        {
            CurrentPos.y -= Drawer.blockSize;
        }
        if (move == Direction.RIGHT)
        {
            CurrentPos.x += Drawer.blockSize;
        }
        if (move == Direction.LEFT)
        {
            CurrentPos.x -= Drawer.blockSize;
        }
        this.snake.updatePos(CurrentPos);
    }

    public boolean checkEatSelf(){
        int trail = snake.getCore().size() - 1;
        while(trail > 0)
        {
           if(CurrentPos.x == snake.getCore().get(trail - 1).getPosition().x && CurrentPos.y == snake.getCore().get(trail - 1).getPosition().y)
           {
               return true;
           }
           trail--;
        }
        return false;
    }

    public boolean checkPos(){

        if(CurrentPos.x >= Drawer.size.x || CurrentPos.y >= Drawer.size.y || CurrentPos.x <= 0 || CurrentPos.y <= 0 ){
            return false;
        }
        if(checkEatSelf()){
            return false;
        }
        return true;
    }

    public Element getSnake() {
        return snake;
    }

    public Element getCandy() {
        return candy;
    }
}
