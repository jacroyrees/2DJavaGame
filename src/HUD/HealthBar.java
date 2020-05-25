package HUD;

import Entities.Creatures.Player;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;

public class HealthBar extends HUD {

    private Handler handler;
    private float x, y;
    private int width, height;
    Player player;

    public HealthBar(Handler handler, float x, float y, Player player) {
        super(handler, x, y, Assets.HUDList.get(0).getWidth(), Assets.HUDList.get(0).getHeight(), player);
        this.x = x;
        this.y = y;
        this.handler = handler;

    }


    public void update() {
        getPlayerVariables();
    }


    public void render(Graphics g) {

        g.drawImage(Assets.HUDList.get(0),(int)(x), (int)(y), null);

    }
}
