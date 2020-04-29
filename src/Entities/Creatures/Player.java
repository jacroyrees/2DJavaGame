package Entities.Creatures;

import graphics.Assets;
import tilegame.Game;
import tilegame.Handler;

import java.awt.*;

public class Player extends Creature {


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
            yMove = -speed;
        }if(handler.getKeyManager().down){
            yMove = speed;
        }if(handler.getKeyManager().left){
            xMove = -speed;
        }if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerArray.get(1), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height,null);

        g.setColor(Color.RED);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }


}
