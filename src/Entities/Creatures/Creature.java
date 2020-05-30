package Entities.Creatures;

import Entities.Entity;
import tilegame.Handler;

public abstract class Creature extends Entity {


    private final long PERIOD = 1500L; // Adjust to suit timing
    private long lastTime = System.currentTimeMillis() - PERIOD;

    protected static final float DEFAULT_SPEED = 3.0f;



    protected int hp;



    protected int damage = 1;
    protected float speed;
    public static final int DEFAULT_CREATURE_WIDTH = 32,
                            DEFAULT_CREATURE_HEIGHT = 32;

    protected float xMove, yMove;



    public Creature(Handler handler, float x, float y, int width, int height, int hp){
        super(handler, x, y, width, height);
        this.hp = hp;
        speed = DEFAULT_SPEED;
        xMove =0;
        yMove = 0;
    }


    public void move(){
        if(!checkEntityCollisions(xMove, 0f)) {
            moveX();
        }if(!checkEntityCollisions(0f, yMove)) {
            moveY();
        }
    }






    public void moveX(){
        if(xMove > 0){ //Moving right

            int tx = (int) (x + xMove + bounds.x + bounds.width) / 32;
            if(!collisionWithTile(tx, (int)(y + bounds.y)) && !collisionWithTile(tx, (int)(y + bounds.y) / 32)){
                x += xMove;
            }else{
                x = tx * 32 - bounds.x - bounds.width - 1;

            }


        }else if(xMove < 0){ //Moving left
            int tx = (int) (x + xMove + bounds.x) / 32;
            if(!collisionWithTile(tx, (int)(y + bounds.y)) && !collisionWithTile(tx, (int)(y + bounds.y) / 32)){
                x += xMove;
            }else{
                x = tx * 32 + 32 - bounds.x;
            }
        }
    }

    public void moveY(){
        if(yMove < 0){//up
            int ty = (int)(y + yMove + bounds.y)/ 32;
            if(!collisionWithTile((int)(x + bounds.x / 32), ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / 32, ty)){
                y += yMove;
            }else{
                y = ty * 32 + 32 - bounds.y;
            }

        }else if(yMove > 0){//down
            int ty = (int)(y + yMove + bounds.y + bounds.height)/ 32;
            if(!collisionWithTile((int)(x + bounds.x / 32), ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / 32, ty)){
                y += yMove;
            }else{
                y = ty * 32 - bounds.y - bounds.height - 1;
            }
        }

    }



    @Override
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getMap().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                if(e instanceof Player){
                    playerDamage(e);
                    Player.damageTaken = true;
                }
                return true;

            }
        }
        Player.damageTaken = false;
        return false;
    }



    public void playerDamage(Entity e){
        long thisTime = System.currentTimeMillis();
        if ((thisTime - lastTime) >= (PERIOD/4)) {
            lastTime = thisTime;

            if(Player.hp - this.getDamage() < 0){
                Player.hp = 0;
            }else{
                Player.hp = Player.hp - this.getDamage();
            }

        }

    }

    protected boolean collisionWithTile(int x, int y){
        return !handler.getMap().getTile(x, y).isTraversable();
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getDamage() {
        return damage;
    }

}
