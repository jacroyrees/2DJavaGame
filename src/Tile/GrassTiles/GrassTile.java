package Tile.GrassTiles;

import Tile.TraversableTile;
import Utilities.Edge;
import graphics.Assets;

import java.awt.image.BufferedImage;
import java.util.Random;

public class GrassTile extends TraversableTile { // A grass tile which isn't on the edge of anything
    public static Random GrassRandom = new Random();

    protected Edge edge;

    public GrassTile(int id) {
        super(Assets.grassArray.get(GrassRandom.nextInt(Assets.grassArray.size())), id); // random grass image
    }

    public GrassTile(int id, int imgID) {
        super(Assets.grassArray.get(imgID), id); // grass img by ID
    }

    public GrassTile(int id, Edge edge) {
        super(Assets.grassArray.get(GrassRandom.nextInt(Assets.grassArray.size())), id);
        switch(edge) {
            case TOPLEFT:
                image = Assets.dirtArray.get(7);
                break;
            case TOP:
                image = Assets.dirtArray.get(3);
                break;
            case TOPRIGHT:
                image = Assets.dirtArray.get(8);
                break;
            case LEFT:
                image = Assets.dirtArray.get(2);
                break;
            case NONE:
                image = randomGrassImage();
                break;
            case RIGHT:
                image = Assets.dirtArray.get(0);
                break;
            case BOTTOMLEFT: // TODO: get correct ID for this
                image = Assets.dirtArray.get(3);
                break;
            case BOTTOM:
                image = Assets.dirtArray.get(1);
                break;
            case BOTTOMRIGHT:
                image = Assets.dirtArray.get(6);
                break;
        }
    }

    private BufferedImage randomGrassImage() {
        return Assets.grassArray.get(GrassRandom.nextInt(Assets.grassArray.size()));
    }

}
