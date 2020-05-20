package Tile;

import graphics.Assets;

public class SandTile extends Tile{

    public SandTile(int id) {
        super(Assets.sandArray.get(0), id, true);
    }


    @Override
    public boolean isTraversable() {
        return true;
    }
}
