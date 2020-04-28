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

        if(game.getKeyManager().up ){
            y -= 3;
        }if(game.getKeyManager().down){
            y += 3;
        }if(game.getKeyManager().left){
            x -= 3;
        }if(game.getKeyManager().right){
            x+=3;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y, width, height,null);
    }


}
