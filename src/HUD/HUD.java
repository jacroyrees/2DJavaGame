package HUD;

import Entities.Creatures.Player;
import tilegame.Handler;

import java.awt.*;

public abstract class HUD {

    private Handler handler;
    private float x, y;
    private int width, height;
    Player player;
    public HUD(Handler handler, float x, float y, int width, int height, Player player){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height ;
        this.player = player;

    }


    public void getPlayerVariables(){

    }

    public abstract void update();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
