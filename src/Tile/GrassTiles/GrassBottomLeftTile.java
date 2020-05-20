package Tile.GrassTiles;

import Tile.Tile;
import graphics.Assets;

public class GrassBottomLeftTile extends Tile {
    public GrassBottomLeftTile(int id) {
        super(Assets.dirtArray.get(6), id, true); // TODO: get correct grass ID for this
    }
}