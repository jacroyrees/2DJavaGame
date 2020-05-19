package Entities.Creatures;

import Entities.EntityManager;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;

public class DullCreature extends Creature {
    private Player player;
    public DullCreature(Handler handler, float x, float y, int width, int height, int hp, Player player) {
        super(handler, x, y, width, height, hp);
        this.player = player;
        this.setSpeed(speed / 2);


    }



    public  void move(){
        if(!checkEntityCollisions(xMove, 0f)) {
            moveX();
        }if(!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }

    @Override
    public void moveY(){

            getDirection();
            if(yMove < 0){//up
                int ty = (int)(y + yMove + bounds.y)/ 32;
                if(!collisionWithTile((int)(x + bounds.x / 32), ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / 32, ty)){
                    getDirection();
                    y += yMove;
                }else{

                    y = ty * 32 + 32 - bounds.y;
                }

            }else if(yMove >= 0){//down
                int ty = (int)(y + yMove + bounds.y + bounds.height)/ 32;
                if(!collisionWithTile((int)(x + bounds.x / 32), ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / 32, ty)){
                    getDirection();
                    y += yMove;
                }else{
                    y = ty * 32 - bounds.y - bounds.height - 1;
                }
            }


    }

    public void getDirection(){
        if(this.getX() > player.getX()){
            this.xMove = -speed;
        }else{
            this.xMove = +speed;
        }

        if(this.getY() > player.getY()){
            this.yMove = -speed;
        }else{
            this.yMove = +speed;
        }
    }

    @Override
    public void moveX(){
        if(xMove > 0){ //Moving right

            int tx = (int) (x + xMove + bounds.x + bounds.width) / 32;
            if(!collisionWithTile(tx, (int)(y + bounds.y)) && !collisionWithTile(tx, (int)(y + bounds.y) / 32)){
                getDirection();
                x += xMove;
            }else{
                x = tx * 32 - bounds.x - bounds.width - 1;

            }


        }else if(xMove <= 0){ //Moving left
            int tx = (int) (x + xMove + bounds.x) / 32;
            if(!collisionWithTile(tx, (int)(y + bounds.y)) && !collisionWithTile(tx, (int)(y + bounds.y) / 32)){
                getDirection();
                x += xMove;
            }else{
                x = tx * 32 + 32 - bounds.x;
            }
        }
    }




/*
        if (!this.canMove()) return false;

        if (this.x == player.getX() && this.y == player.getY()) {
            player.damage(1);
            this.restingTurns += 1;
            return false;
        }

        // The player's x, y distance from the entity, calculated by the player's x, y subtracted from their x, y.
        // No need for the distance to be negative, therefore Math.abs().
        int distanceX = Math.abs(player.getX() - this.x);
        int distanceY = Math.abs(player.getY() - this.y);

        if (distanceX > distanceY) {
            if (this.getX() > player.getX()) {
                if (collisionLayer[this.x - 1][this.y] == 99999) { // If there's a wall...
                    return false;
                } else { // Otherwise, move left.
                    this.x -= 1;
                }
            } else {
                if (collisionLayer[this.x + 1][this.y] == 99999) { // If there's a wall...
                    return false;
                } else {
                    this.x += 1; // Otherwise, move right.
                }
            }
        } else {
            if (this.getY() > player.getY()) {
                if (collisionLayer[this.x][this.y - 1] == 99999) { // If there's a wall...
                    return false;
                } else {
                    this.y -= 1; // Otherwise, move up.
                }
            } else {
                if (collisionLayer[this.x][this.y + 1] == 99999) { // If there's a wall...
                    return false;
                } else {
                    this.y += 1; // Otherwise, move down.
                }
            }
        }

        if (this.x == player.getX() && this.y == player.getY()) { // If the entity is on top of the player...
            player.damage(1);
            this.restingTurns += 1;
            return false;
        }

        return true;
    }*/













    public void update() {
        move();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.creature.get(0),(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), null);

    }

}


