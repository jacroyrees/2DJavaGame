package Tile.DirtTiles;

import Tile.TraversableTile;
import graphics.Assets;

public class DirtTile extends TraversableTile {
    public DirtTile(int id) {
        super(Assets.dirtArray.get(4), id);
    }
}
