package Entities.Creatures;

import graphics.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DullCreature extends Creature {
    private Player player;
    private BufferedImage image;
    private int lastDirectionX;
    private int lastDirectionY;
    private int index;
    private int randomDurationMove;
    public DullCreature(Handler handler, float x, float y, int width, int height, int hp, Player player, int damage) {
        super(handler, x, y, width, height, hp);
        this.player = player;
        this.speed = speed / 2;
        Random random = new Random();
        image = Assets.creature.get(random.nextInt(7));
        this.damage = damage;
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;



    }




    private void getUserInput() {
        xMove = 0;
        yMove = 0;


        if ((((this.getX() >= player.getX()) && this.getX() <= player.getX() + 200) || ((this.getX() < player.getX())
                && (this.getX() > player.getX() - 200))) && (((this.getY() >= player.getY()) && ((this.getY() <=player.getY() + 200))) || ((this.getY() <= player.getY()) && this.getY() >= player.getY() - 200))) {


            if (((this.getX() > player.getX()) && this.getX() < player.getX() + 200)) {
                this.xMove = -speed;
            } else if ((this.getX() < player.getX()) && this.getX() > player.getX() - 200) {
                this.xMove = +speed;

            } else {
                this.xMove = 0;
            }


            if ((this.getY() > player.getY()) && this.getY() < player.getY() + 200) {
                this.yMove = -speed;
            } else if ((this.getY() < player.getY()) && this.getY() > player.getY() - 200) {
                this.yMove = +speed;
            } else {
                this.yMove = 0;
            }




        }else{
            randomDirection();
        }


    }







    public void randomDirection(){
        Random randomdirection = new Random();
        Random randomDuration = new Random();

        if(index <= randomDurationMove) {
            xMove = lastDirectionX;
            yMove = lastDirectionY;
            index++;
        }else {
            randomDurationMove = randomdirection.nextInt(50);
            index = 0;
            int randomInt = randomdirection.nextInt(4);
            if (randomInt == 0) {
                xMove = +speed;
                lastDirectionX = (int)xMove;
            } else if (randomInt == 1) {
                xMove = -speed;
                lastDirectionX = (int)xMove;
            } else if (randomInt == 2) {
                yMove = +speed;
                lastDirectionY = (int)yMove;
            } else if (randomInt == 3) {
                yMove = -speed;
                lastDirectionY = (int)yMove;
            }
            System.out.println(randomInt);
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
        g.drawImage(image,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), null);

    }

}


