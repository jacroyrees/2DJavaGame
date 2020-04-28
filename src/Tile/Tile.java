package Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];




    public final int TILE_WIDTH = 32,
                          TILE_HEIGHT = 32;

    protected BufferedImage image;



    protected final int id;

    public Tile(BufferedImage image, int id){
        this.image = image;
        this.id = id;
    }


    public void update(){

    }

    public void render(Graphics g, int positionX, int positionY){
        g.drawImage(image, positionX, positionY, TILE_WIDTH, TILE_HEIGHT, null);

    }

    public boolean isCollidable(){
        return true;
    }

    public int getId() {
        return id;
    }

}
