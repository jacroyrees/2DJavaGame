package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {


    //public static BufferedImage stone, sand, grass, mud, sandStone, player;
    public static BufferedImage[] stoneArray = new BufferedImage[10];
    public static BufferedImage[] sandArray = new BufferedImage[10];
    public static BufferedImage[] grassArray = new BufferedImage[10];
    public static BufferedImage[] mudArray = new BufferedImage[10];
    public static BufferedImage[] sandStoneArray = new BufferedImage[10];
    public static BufferedImage[] playerArray = new BufferedImage[10];

    private static final int width = 32;
    private static final int height = 32;

    public static void init() {
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/masterTileSet.png"));
        SpriteSheet playerSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/playerSpriteSheet.png"));

        int ind = 0;
        for(int i = 0; i < 10; i++){
            stoneArray[i] = tileSheet.cropSheet(ind, 0, width, height);
            sandArray[i] = tileSheet.cropSheet(ind, 32, width, height);
            grassArray[i] = tileSheet.cropSheet(ind, 64, width, height);
            mudArray[i] = tileSheet.cropSheet(ind, 96, width, height);
            sandStoneArray[i] = tileSheet.cropSheet(ind, 128, width, height);

            ind += 32;

        }
        ind = 0;
        for(int j = 0; j < 3; j++){
            playerArray[j] = playerSprite.cropSheet(ind, 0, width, height);
        ind += 32;}
      /*  stone = tileSheet.cropSheet(0, 0, width, height);
        sand = tileSheet.cropSheet(0, width, width, height);
        grass = tileSheet.cropSheet(0, width * 2, width, height);
        mud = tileSheet.cropSheet(0, width * 3, width, height);
        sandStone = tileSheet.cropSheet(0, width * 4, width, height);
*/
        //player = playerSprite.cropSheet(0, 0, width, height);
    }
}
