package Tile;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class StoneTile extends Tile {
    public StoneTile( int id) {
        super(Assets.stoneArray[1], id);
    }

    @Override
    public boolean isCollidable() {
        return false;
    }
}
