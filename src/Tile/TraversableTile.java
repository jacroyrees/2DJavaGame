package Tile;

import java.awt.image.BufferedImage;

public abstract class TraversableTile extends Tile {
    public TraversableTile(BufferedImage image, int id) {
        super(image, id, true);
    }
}
