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
    public Tile(BufferedImage image, int id){
        this.image = image;
        if(this instanceof GrassTile){
            this.image = Assets.grassArray.get(random.nextInt(Assets.grassArray.size()));
        }
        this.id = id;
        tiles[id] = this;
    }

    public int getTILE_WIDTH() {
        return TILE_WIDTH;
    }

    public int getTILE_HEIGHT() {
        return TILE_HEIGHT;
    }

    public static final int TILE_WIDTH = 32,
            TILE_HEIGHT = 32;
    public static Tile[] tiles = new Tile[256];

    Random random = new Random();




    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    protected BufferedImage image;



    protected final int id;



    public void update(){

    }

    public void render(Graphics g, int positionX, int positionY){
        g.drawImage(image, positionX, positionY, TILE_WIDTH, TILE_HEIGHT, null);

    }

    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }


    public int getVariantImages(ArrayList<BufferedImage> tileArrayList){
        Random random = new Random();
            int randomInt = random.nextInt(tileArrayList.size());
            return randomInt;

    }

    public static Tile stone = new StoneTile(00);
    public static Tile DirtTile = new DirtTile(15);

    public static Tile grassBottomLeft = new GrassBottomLeftTile(10);
    public static Tile grassBottomRight = new GrassBottomRightTile(12);
    public static Tile grassLeft = new GrassLeftTile(15);
    public static Tile grassRight = new GrassRightTile(17);
    public static Tile grassTopLeft = new GrassTopLeftTile(13);
    public static Tile grassTopRight = new GrassTopRightTile(14);
    public static Tile grassTopTile = new GrassTopTile(19);
    public static Tile grassBottomTile = new GrassBottomTile(11);
    public static Tile grassTile = new GrassTile(18);



    }


