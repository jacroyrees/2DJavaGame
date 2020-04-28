package Tile;

import graphics.Assets;

public class SandStoneTile extends Tile{

    public SandStoneTile( int id) {
        super(Assets.sandStoneArray[1], id);
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

}
