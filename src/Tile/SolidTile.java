package Tile;

import graphics.Assets;

import java.awt.image.BufferedImage;

public class SolidTile extends Tile {
    public SolidTile(BufferedImage image, int id) {
        super(image, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

