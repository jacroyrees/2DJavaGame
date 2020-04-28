package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {


    //public static BufferedImage stone, sand, grass, mud, sandStone, player;
    public static ArrayList<BufferedImage> stoneArray = new ArrayList<>();
    public static ArrayList<BufferedImage> sandArray = new ArrayList<>();
    public static ArrayList<BufferedImage> grassArray = new ArrayList<>();
    public static ArrayList<BufferedImage> mudArray = new ArrayList<>();
    public static ArrayList<BufferedImage> sandStoneArray = new ArrayList<>();;
    public static ArrayList<BufferedImage> playerArray = new ArrayList<>();

    private static final int width = 32;
    private static final int height = 32;

    public static void init() {
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/masterTileSet.png"));
        SpriteSheet playerSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/playerSpriteSheet.png"));

        int ind = 0;
        for(int i = 0; i < 10; i++){
            stoneArray.add(tileSheet.cropSheet(ind, 0, width, height));
            sandArray.add(tileSheet.cropSheet(ind, 32, width, height));
            grassArray.add(tileSheet.cropSheet(ind, 64, width, height));
            mudArray.add(tileSheet.cropSheet(ind, 96, width, height));
            sandStoneArray.add(tileSheet.cropSheet(ind, 128, width, height));

            ind = ind + 32;

        }
        ind = 0;
        for(int j = 0; j < 3; j++){
            playerArray.add(playerSprite.cropSheet(ind, 0, width, height));
        ind += 32;}



    }
}
