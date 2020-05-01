package Tile;

import java.awt.image.BufferedImage;

public abstract class NonTraversableTile extends Tile {
    public NonTraversableTile(BufferedImage image, int id) {
        super(image, id, false);
    }
}
