package Entities.Creatures;

import Entities.Entity;

import java.awt.*;

public class Creature extends Entity {
    protected int hp;

    public Creature(float x, float y, int hp){
        super(x, y);
        this.hp = hp;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
