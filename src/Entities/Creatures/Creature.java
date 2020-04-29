package Entities.Creatures;

import Entities.Entity;
import tilegame.Game;
import tilegame.Handler;

import java.awt.*;

public abstract class Creature extends Entity {


    protected static final float DEFAULT_SPEED = 3.0f;



    protected int hp;
    protected float speed;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;

    protected float xMove, yMove;



    public Creature(Handler handler, float x, float y, int width, int height, int hp){
        super(handler, x, y, width, height);
        this.hp = hp;
        speed = DEFAULT_SPEED;
        xMove =0;
        yMove = 0;
    }

    public void move(){
        moveX();
        moveY();

    }

    public void moveX(){
        if(xMove > 0){ //Moving right

            int tx = (int) (x + xMove + bounds.x + bounds.width) / 32;
            if(!collisionWithTile(tx, (int)(y + bounds.y)) && !collisionWithTile(tx, (int)(y + bounds.y) / 32)){
                x += xMove;
            }


        }else if(xMove < 0){ //Moving left
            int tx = (int) (x + xMove + bounds.x) / 32;
            if(!collisionWithTile(tx, (int)(y + bounds.y)) && !collisionWithTile(tx, (int)(y + bounds.y) / 32)){
                x += xMove;
            }
        }
    }

    public void moveY(){
        if(yMove < 0){//up
            int ty = (int)(y + yMove + bounds.y)/ 32;
            if(!collisionWithTile((int)(x + bounds.x / 32), ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / 32, ty)){
                y += yMove;
            }

        }else if(yMove > 0){//down
            int ty = (int)(y + yMove + bounds.y + bounds.height)/ 32;
            if(!collisionWithTile((int)(x + bounds.x / 32), ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / 32, ty)){
                y += yMove;
            }
        }

    }


    protected boolean collisionWithTile(int x, int y){
        return handler.getMap().getTile(x, y).isSolid();
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }


}
