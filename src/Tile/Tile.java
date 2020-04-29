package Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

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


    public static Tile stoneTile = new StoneTile(0);
    public static Tile sandTile = new SandTile(1);
    public static Tile grassTile = new GrassTile(2);
    public static Tile mudTile = new MudTile(3);
    public static Tile sandStoneTile = new SandStoneTile(4);

    public static Tile newDirtTile = new NewDirtTile(5);
    public static Tile newGrassLeftTile = new NewGrassLeftTile(6);
    public static Tile newGrassRightTile = new NewGrassRightTile(7);
    public static Tile newGrassTile = new NewGrassTile(8);







    protected BufferedImage image;



    protected final int id;

    public Tile(BufferedImage image, int id){
        this.image = image;
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
