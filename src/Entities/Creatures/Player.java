package Entities.Creatures;

import graphics.Assets;

import java.awt.*;

public class Player extends Creature {
    public Player(float x, float y, int hp) {
        super(x, y, hp);
    }


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y, null);
    }


}
