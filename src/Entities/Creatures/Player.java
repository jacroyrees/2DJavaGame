package Entities.Creatures;

import graphics.Assets;
import tilegame.Game;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private BufferedImage image = Assets.playerArray.get(1);

    public Player(Handler handler, float x, float y, int width, int height, int hp) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, hp);

        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;

    }


    @Override
    public void update() {
        getUserInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getUserInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            image = Assets.playerArray.get(9);
            yMove = -speed;


        }if(handler.getKeyManager().down){
            image = Assets.playerArray.get(1);
            yMove = speed;

        }if(handler.getKeyManager().left){
            image = Assets.playerArray.get(4);
            xMove = -speed;

        }if(handler.getKeyManager().right){
            image = Assets.playerArray.get(7);
            xMove = speed;

        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height,null);

        g.setColor(Color.RED);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }


}
