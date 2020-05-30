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

    public static ArrayList<BufferedImage> creature = new ArrayList<>();

    public static ArrayList<BufferedImage> dirtArray = new ArrayList<>();
    public static ArrayList<BufferedImage> tree = new ArrayList<>();
    public static ArrayList<BufferedImage> HUDList = new ArrayList<>();



    private static final int width = 32;
    private static final int height = 32;



    public static void init() {
        SpriteSheet HUD = new SpriteSheet(ImageLoader.loadImage("/res/textures/HUD/HealthBar.png"));

        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/masterTileSet.png"));
        SpriteSheet playerSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/playerSpriteSheet.png"));
        SpriteSheet dirtSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/DirtSprite.png"));
        SpriteSheet grassSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/GrassSprite.png"));
        SpriteSheet treeSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/treeSpriteSheet.png"));


        //HUDList.add(HUD.cropSheet(0,0,256,128));
        SpriteSheet creatureSprite = new SpriteSheet(ImageLoader.loadImage("/res/textures/CreatureTest.png"));

        for(int i = 0; i < 224; i += 32){
            creature.add(creatureSprite.cropSheet(i, 0, width, height));

        }

        for (int j = 0; j < 300; j += 30) {

                HUDList.add(HUD.cropSheet(0, j, 300, 30));
            }




        for (int j = 0; j < 128; j += 64) {
            for (int k = 0; k < 128; k += 64) {
                tree.add(treeSprite.cropSheet(k, j, width * 2, height * 2));
            }
        }



        int ind = 0;
        for (int i = 0; i < 10; i++) {

            stoneArray.add(tileSheet.cropSheet(ind, 0, width, height));
            sandArray.add(tileSheet.cropSheet(ind, 32, width, height));
            //grassArray.add(tileSheet.cropSheet(ind, 64, width, height));
            mudArray.add(tileSheet.cropSheet(ind, 96, width, height));
            sandStoneArray.add(tileSheet.cropSheet(ind, 128, width, height));

            ind = ind + width;

        }

        for (int j = 0; j < 64; j += 32) {
            for (int k = 0; k < 64; k += 32) {
                grassArray.add(grassSprite.cropSheet(k, j, width, height));
            }
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

        for (int j = 0; j < 96; j += 32) {
            for (int k = 0; k < 96; k += 32) {
                dirtArray.add(dirtSprite.cropSheet(k, j, width, height));
            }
        }


    }
}
