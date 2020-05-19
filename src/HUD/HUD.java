package HUD;

import tilegame.Handler;

import java.awt.*;

public abstract class HUD {

    private Handler handler;
    private float x, y;
    private int width, height;
    public HUD(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }

    public abstract void update();

    public abstract void render(Graphics g);


}
