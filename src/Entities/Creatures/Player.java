package Entities.Creatures;

import Entities.Entity;
import graphics.Animation;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    private Animation animDown, animUp, animLeft, animRight;
    private Animation lastAnimation;
    public static int hp;
    private final long PERIOD = 1500L; // Adjust to suit timing
    private long lastTime = System.currentTimeMillis() - PERIOD;
    public static boolean damageTaken = false;








    public Player(Handler handler, float x, float y, int hp) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, hp);
        this.hp = hp;
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 16;
        bounds.height = 16;

        animDown = new Animation(500, Assets.playerDown, this);
        animUp = new Animation(500, Assets.playerUp, this);
        animLeft = new Animation(500, Assets.playerLeft, this);
        animRight = new Animation(500, Assets.playerRight, this);
        lastAnimation = animDown;
        System.out.println("Hp" + hp);
    }




    @Override
    public void update() {
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();
        updateHealth();
        getUserInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }



    private void getUserInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){

            yMove = -speed;


        }if(handler.getKeyManager().down){

            yMove = speed;

        }if(handler.getKeyManager().left){

            xMove = -speed;

        }if(handler.getKeyManager().right){

            xMove = speed;

        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height,null);

        //g.setColor(Color.RED);
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),(int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            lastAnimation = animLeft;
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            lastAnimation = animRight;
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            lastAnimation = animUp;
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            lastAnimation = animDown;
            return animDown.getCurrentFrame();
        }else{
            return lastAnimation.getCurrentFrame();
        }
    }


    public void updateHealth() {//Called every "Tick"
        long thisTime = System.currentTimeMillis();


        if ((thisTime - lastTime) >= PERIOD && !damageTaken) {

            lastTime = thisTime;

            if(hp < 10) { //If my variable is true
                hp = hp+1;//Setting my boolean to true
                System.out.println(hp);
            }
        }
    }

    //TODO :: Sort out the bug where user doesnt lose health when standing next to entity









}






