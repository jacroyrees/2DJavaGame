package graphics;

import Entities.Creatures.Creature;
import Entities.Creatures.Player;
import Entities.Entity;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Animation {
    private int speed, index;
    private long lastTime, timer;
    private ArrayList<BufferedImage> frames;
    private Entity e;

    public Animation(int speed, ArrayList<BufferedImage> frames, Entity e){
        this.speed = speed;
        this.frames = frames;
        this.e = e;
        index = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            if(((Creature)e).getxMove() == 0 && ((Creature)e).getyMove() == 0){
                index = 2;
            }else {

                index++;
                timer = 0;
            }
                if (index >= frames.size()) {
                    index = 0;
                }

        }
    }

    public  BufferedImage getCurrentFrame(){
        return frames.get(index);
    }
}
