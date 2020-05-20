package Tile.GrassTiles;

import Tile.Tile;
import graphics.Assets;

public class GrassTopTile extends Tile {
    public GrassTopTile(int id) {
        super(Assets.dirtArray.get(3), id, true);
    }
}

