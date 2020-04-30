package Tile.StoneTiles;

import Tile.Tile;
import graphics.Assets;

public class StoneTile extends Tile {
    public StoneTile( int id) {
        super(Assets.stoneArray.get(0), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
