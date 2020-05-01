package Tile;

import Tile.DirtTiles.DirtTile;
import Tile.GrassTiles.*;
import Tile.StoneTiles.SandStoneTile;
import Tile.StoneTiles.StoneTile;
import Utilities.Edge;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public abstract class Tile {
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;

    public static Tile[] tiles = new Tile[256];

    protected final int id;
    protected BufferedImage image;
    protected boolean traversable;

    Random random = new Random();

    public Tile(BufferedImage image, int id, boolean traversable){
        this.image = image;
        this.id = id;
        tiles[id] = this;
        this.traversable = traversable;
    }



    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }



    public void update(){

    }

    public void render(Graphics g, int positionX, int positionY){
        g.drawImage(image, positionX, positionY, TILE_WIDTH, TILE_HEIGHT, null);

    }

    public boolean isTraversable() {
        return this.traversable;
    }

    public int getId() {
        return id;
    }


    public int getVariantImages(ArrayList<BufferedImage> tileArrayList){
        Random random = new Random();
            int randomInt = random.nextInt(tileArrayList.size());
            return randomInt;

    }

/*    public static Tile stone = new StoneTile(00);
    public static Tile DirtTile = new DirtTile(15);

    public static Tile grassBottomLeft = new GrassBottomLeftTile(10);
    public static Tile grassBottomRight = new GrassBottomRightTile(12);
    public static Tile grassLeft = new GrassLeftTile(15);
    public static Tile grassRight = new GrassRightTile(17);
    public static Tile grassTopLeft = new GrassTopLeftTile(13);
    public static Tile grassTopRight = new GrassTopRightTile(14);
    public static Tile grassTopTile = new GrassTopTile(19);
    public static Tile grassBottomTile = new GrassBottomTile(11);
    public static Tile grassTile = new GrassTile(18);*/

    public static Tile stone = new StoneTile(00);
    public static Tile DirtTile = new DirtTile(15);

    public static Tile grassBottomLeft = new GrassTile(10, Edge.LEFT);
    public static Tile grassBottomRight = new GrassTile(12, Edge.RIGHT);
    public static Tile grassLeft = new GrassTile(15, Edge.LEFT);
    public static Tile grassRight = new GrassTile(17, Edge.RIGHT);
    public static Tile grassTopLeft = new GrassTile(13, Edge.TOPLEFT);
    public static Tile grassTopRight = new GrassTile(14, Edge.TOPRIGHT);
    public static Tile grassTopTile = new GrassTile(19, Edge.TOP);
    public static Tile grassBottomTile = new GrassTile(11, Edge.BOTTOMRIGHT);
    public static Tile grassTile = new GrassTile(18);



    }


