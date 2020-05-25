package Entities.Creatures;

import graphics.Assets;
import tilegame.Handler;

import java.awt.*;

public class DullCreature extends Creature {
    private Player player;
    public DullCreature(Handler handler, float x, float y, int width, int height, int hp, Player player) {
        super(handler, x, y, width, height, hp);
        this.player = player;
        this.speed = speed / 2;


        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;



    }




    private void getUserInput(){
        xMove = 0;
        yMove = 0;


        if (this.getX() > player.getX()) {
            this.xMove = -speed;
        } else {
            this.xMove = +speed;

        }


        if (this.getY() > player.getY()) {
            this.yMove = -speed;
        } else {
            this.yMove = +speed;
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

        getUserInput();
        move();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.creature.get(0),(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), null);

    }

}


