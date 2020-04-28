package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {


    public static BufferedImage stone, sand, grass, mud, sandStone, player;


    private static final int width = 32;
    private static final int height = 32;

    public static void init() {
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/masterTileSet.png"));
        SpriteSheet playerSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/playerSpriteSheet.png"));

        stone = tileSheet.cropSheet(0, 0, width, height);
        sand = tileSheet.cropSheet(0, width, width, height);
        grass = tileSheet.cropSheet(0, width * 2, width, height);
        mud = tileSheet.cropSheet(0, width * 3, width, height);
        sandStone = tileSheet.cropSheet(0, width * 4, width, height);

        player = playerSprite.cropSheet(0, 0, width, height);

    }
}
