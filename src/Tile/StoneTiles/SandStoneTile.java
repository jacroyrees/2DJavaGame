package Tile.StoneTiles;

import Tile.Tile;
import Tile.NonTraversableTile;
import graphics.Assets;

public class SandStoneTile extends NonTraversableTile {

    public SandStoneTile( int id) {
        super(Assets.sandStoneArray.get(0), id);
    }

}
