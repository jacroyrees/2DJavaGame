package Tile;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class StoneTile extends Tile {
    public StoneTile( int id) {
        super(Assets.stoneArray.get(0), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
