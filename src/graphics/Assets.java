package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {


    //public static BufferedImage stone, sand, grass, mud, sandStone, player;
    public static ArrayList<BufferedImage> stoneArray = new ArrayList<>();
    public static ArrayList<BufferedImage> sandArray = new ArrayList<>();
    public static ArrayList<BufferedImage> grassArray = new ArrayList<>();
    public static ArrayList<BufferedImage> mudArray = new ArrayList<>();
    public static ArrayList<BufferedImage> sandStoneArray = new ArrayList<>();
    ;
    public static ArrayList<BufferedImage> playerLeft = new ArrayList<>();
    public static ArrayList<BufferedImage> playerRight = new ArrayList<>();
    public static ArrayList<BufferedImage> playerUp = new ArrayList<>();
    public static ArrayList<BufferedImage> playerDown = new ArrayList<>();

    public static ArrayList<BufferedImage> newDirt = new ArrayList<>();

    private static final int width = 32;
    private static final int height = 32;

    public static void init() {
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/masterTileSet.png"));
        SpriteSheet playerSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/playerSpriteSheet.png"));
        SpriteSheet dirtSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/Dirt.png"));

        int ind = 0;
        for (int i = 0; i < 10; i++) {

            stoneArray.add(tileSheet.cropSheet(ind, 0, width, height));
            sandArray.add(tileSheet.cropSheet(ind, 32, width, height));
            grassArray.add(tileSheet.cropSheet(ind, 64, width, height));
            mudArray.add(tileSheet.cropSheet(ind, 96, width, height));
            sandStoneArray.add(tileSheet.cropSheet(ind, 128, width, height));

            ind = ind + width;

        }


        for (int j = 0; j < 128; j += 32) {
            for (int k = 0; k < 96; k += 32) {
                if (j == 0) {
                    playerDown.add(playerSprite.cropSheet(k, j, width, height));
                } else if (j == width) {
                    playerLeft.add(playerSprite.cropSheet(k, j, width, height));
                } else if (j == width * 2) {
                    playerRight.add(playerSprite.cropSheet(k, j, width, height));
                } else if (j == width * 3) {
                    playerUp.add(playerSprite.cropSheet(k, j, width, height));
                }


            }
        }

        for (int j = 0; j < 64; j += 32) {
            for (int k = 0; k < 64; k += 32) {
                newDirt.add(dirtSprite.cropSheet(k, j, width, height));
            }


        }
    }
}
