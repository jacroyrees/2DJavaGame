package HUD;

import Entities.Creatures.Player;
import UserIO.KeyManager;
import UserIO.MouseManager;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Inventory extends HUD {

    private Handler handler;
    private float x, y;
    private boolean inventory = false;


    private BufferedImage image;

    public Inventory(Handler handler, float x, float y, Player player) {
        super(handler, x, y, Assets.Inventory.get(0).getWidth(), Assets.Inventory.get(0).getHeight(), player);
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.image = Assets.Inventory.get(0);



    }


    private void onOpen(){
      if(handler.getMouseManager().isLeftPressed() && (handler.getMouseManager().getMouseX() > 780 && handler.getMouseManager().getMouseX() < 830)
              && (handler.getMouseManager().getMouseY() > 295 && handler.getMouseManager().getMouseY() < 350) && inventory == false) {
        inventory = true;
        System.out.println("Open");
      }

    }
    private void onClose(){
        if(handler.getMouseManager().isLeftPressed() && (handler.getMouseManager().getMouseX() > 780 && handler.getMouseManager().getMouseX() < 830)
                && (handler.getMouseManager().getMouseY() > 295 && handler.getMouseManager().getMouseY() < 350) && inventory == true) {
            inventory = false;
            System.out.println("Close");
        }

    }

    public void inventoryStatus(){
        if(inventory == false){
            onOpen();
        }else{
            onClose();
        }
    }


    public void update() {

        inventoryStatus();
    }


    public void render(Graphics g) {

        g.drawImage(image, (int)x, (int)y, null);

    }





}