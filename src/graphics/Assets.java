package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage stone, sand, grass, mud, sandstone;


    private static final int width = 32;
    private static final int height = 32;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/masterTileSet.png"));
        stone = sheet.cropSheet(0, 0, width, height);
        sand  = sheet.cropSheet(0, width, width, height);
        grass  = sheet.cropSheet(0, width * 2, width, height);
        mud = sheet.cropSheet(0, 0, width * 3, height);
        sandstone  = sheet.cropSheet(0, width * 4, width, height);

    }
}
