package Tile.GrassTiles;

import Tile.Tile;
import graphics.Assets;

public class GrassTopRightTile extends Tile {
    public GrassTopRightTile(int id) {
        super(Assets.dirtArray.get(8), id, true);
    }
}