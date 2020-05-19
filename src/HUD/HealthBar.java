package HUD;

import graphics.Assets;
import tilegame.Handler;

import java.awt.*;

public class HealthBar extends HUD {

    private Handler handler;
    private float x, y;
    private int width, height;

    public HealthBar(Handler handler, float x, float y) {
        super(handler, x, y, Assets.HUDList.get(0).getWidth(), Assets.HUDList.get(0).getHeight());

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.HUDList.get(0), (int)x, (int)y, width, height, null);

    }
}
