package Entities.Creatures;

import graphics.Assets;
import tilegame.Game;

import java.awt.*;

public class Player extends Creature {

    private Game game;
    public Player(Game game, float x, float y, int width, int height, int hp) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, hp);
        this.game = game;
    }


    @Override
    public void update() {
        getUserInput();
        move();
    }

    private void getUserInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up){
            yMove = -speed;
        }if(game.getKeyManager().down){
            yMove = speed;
        }if(game.getKeyManager().left){
            xMove = -speed;
        }if(game.getKeyManager().right){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerArray.get(1), (int)x, (int)y, width, height,null);
    }


}
