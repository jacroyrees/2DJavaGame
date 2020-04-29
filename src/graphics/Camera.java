package graphics;

import Entities.Entity;
import tilegame.Game;

public class Camera {



    private Game game;
    private float xOffset, yOffset;

    public Camera(Game game, float xOffset, float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.game = game;
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth()/2;
        yOffset = e.getY() - game.getHeight() /2 + e.getWidth()/2;

    }


  /*  public void moveCamera(float xAmount, float yAmount){
        xOffset += xAmount;
        yOffset += yAmount;
    }
*/
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
