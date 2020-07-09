package HUD;

import Entities.Creatures.Player;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HealthBar extends HUD {

    private Handler handler;
    private float x, y;
    private int width, height;
    Player player;
    private BufferedImage image;

    public HealthBar(Handler handler, float x, float y, Player player) {
        super(handler, x, y, Assets.HUDList.get(0).getWidth(), Assets.HUDList.get(0).getHeight(), player);
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.image =  Assets.HUDList.get(0);

    }


    public void getPlayerHealth(){
        if(Player.hp == 10){
            image = Assets.HUDList.get(0);
        }else if(Player.hp == 9) {
            image = Assets.HUDList.get(1);
        } else if(Player.hp == 8) {
            image = Assets.HUDList.get(2);
        }else if(Player.hp == 7) {
            image = Assets.HUDList.get(3);
        }else if(Player.hp == 6) {
            image = Assets.HUDList.get(4);
        }else if(Player.hp == 5) {
            image = Assets.HUDList.get(5);
        }else if(Player.hp == 4) {
            image = Assets.HUDList.get(6);
        }else if(Player.hp == 3) {
            image = Assets.HUDList.get(7);
        }else if(Player.hp == 2) {
            image = Assets.HUDList.get(8);
        }else{
            image = Assets.HUDList.get(9);
        }

    }



    public void update() {
        getPlayerHealth();
    }


    public void render(Graphics g) {

        g.drawImage(image, (int)x, (int)y, null);

    }
}
