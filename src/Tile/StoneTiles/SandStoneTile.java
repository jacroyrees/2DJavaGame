package Tile.StoneTiles;

import Tile.Tile;
import graphics.Assets;

public class SandStoneTile extends Tile{

    public SandStoneTile( int id) {
        super(Assets.sandStoneArray.get(0), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
