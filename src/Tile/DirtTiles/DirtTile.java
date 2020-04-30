package Tile.DirtTiles;

import Tile.Tile;
import graphics.Assets;

public class DirtTile extends Tile {
    public DirtTile(int id) {
        super(Assets.newDirt.get(2), id);
    }
}
