package HUD;

import Entities.Creatures.Player;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Inventory extends HUD {

    private Handler handler;
    private float x, y;
    private int width, height;
    Player player;
    private BufferedImage image;

    public Inventory(Handler handler, float x, float y, Player player) {
        super(handler, x, y, Assets.Inventory.get(0).getWidth(), Assets.Inventory.get(0).getHeight(), player);
        this.x = x;
        this.y = y;
        this.handler = handler;
        this.image = Assets.Inventory.get(0);

    }







    public void update() {

    }


    public void render(Graphics g) {

        g.drawImage(image, (int)x, (int)y, null);

    }
}