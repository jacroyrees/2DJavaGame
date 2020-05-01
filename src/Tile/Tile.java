package Tile;

import Tile.DirtTiles.DirtTile;
import Tile.GrassTiles.*;
import Tile.StoneTiles.SandStoneTile;
import Tile.StoneTiles.StoneTile;
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

    public static Tile stone = new StoneTile(0);
    public static Tile DirtTile = new DirtTile(5);

    public static Tile grassBottomLeft = new GrassBottomLeftTile(1);
    public static Tile grassBottomRight = new GrassBottomRightTile(2);
    public static Tile grassLeft = new GrassLeftTile(6);
    public static Tile grassRight = new GrassRightTile(7);
    public static Tile grassTopLeft = new GrassTopLeftTile(3);
    public static Tile grassTopRight = new GrassTopRightTile(4);
    public static Tile grassTopTile = new GrassTopTile(9);
    public static Tile grassBottomTile = new GrassBottomTile('a');
    public static Tile grassTile = new GrassTile(8);



    }


