package Entities.Creatures;

import Entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {


    protected static final float DEFAULT_SPEED = 3.0f;



    protected int hp;
    protected float speed;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;

    protected float xMove, yMove;



    public Creature(float x, float y, int width, int height, int hp){ds
        super(x, y, width, height);
        this.hp = hp;
        speed = DEFAULT_SPEED;
        xMove =0;
        yMove = 0;
    }

    public void move(){
        x += xMove;
        y += yMove;
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
