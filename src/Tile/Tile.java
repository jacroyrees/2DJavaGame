package Tile;

import Tile.DirtTiles.DirtTile;
import Tile.GrassTiles.GrassLeftTile;
import Tile.GrassTiles.GrassRightTile;
import Tile.GrassTiles.GrassTile;
import Tile.GrassTiles.StoneTiles.SandStoneTile;
import Tile.GrassTiles.StoneTiles.StoneTile;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Tile {
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
    public static Tile stoneTile = new StoneTile(0);
    public static Tile sandTile = new SandTile(1);
    public static Tile grassTile = new GrassTile(2);
    //public static Tile mudTile = new MudTile(3);
    public static Tile sandStoneTile = new SandStoneTile(4);

    public static Tile newDirtTile = new DirtTile(5);
    public static Tile newGrassLeftTile = new GrassLeftTile(6);
    public static Tile newGrassRightTile = new GrassRightTile(7);
    public static Tile newGrassTile = new GrassTile(8);


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    protected BufferedImage image;



    protected final int id;

    public Tile(BufferedImage image, int id){
        this.image = image;
        if(this instanceof GrassTile){
            this.image = Assets.grassArray.get(random.nextInt(Assets.grassArray.size()));
        }
        this.id = id;
        tiles[id] = this;
    }


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

}
