package Tile.StoneTiles;

import Tile.Tile;
import Tile.NonTraversableTile;
import graphics.Assets;

public class StoneTile extends NonTraversableTile {
    public StoneTile( int id) {
        super(Assets.stoneArray.get(0), id);
    }
}
