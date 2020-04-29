package graphics;

import Entities.Entity;
import Tile.Tile;
import tilegame.Game;
import tilegame.Handler;

public class Camera {



    private Handler handler;
    private float xOffset, yOffset;

    public Camera(Handler handler, float xOffset, float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight() /2 + e.getWidth()/2;
        checkBlankSpace();

    }


    public void moveCamera(float xAmount, float yAmount){
        xOffset += xAmount;
        yOffset += yAmount;
        checkBlankSpace();
    }

    public void checkBlankSpace(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
            xOffset = handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }

        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOffset = handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }

    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

}
