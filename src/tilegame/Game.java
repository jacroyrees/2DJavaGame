package tilegame;

import display.Display;
import graphics.Assets;

import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game implements Runnable {

    private Display display;

    public int width, height;
    public String title;

    private boolean isRunning = false;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage test;
    private SpriteSheet sheet;

    public Game(String title, int width, int height) {

        this.width = width;
        this.height = height;
        this.title = title;



    }

    private void init() {
        Assets.init();
        display = new Display(title, width, height);



    }

    int x = 0;

    private void update() {
        x+= 1;
    }

    private void render() {
        //Buffer Strategy is a way to draw to the screen -> Using buffers, hidden screen in advance stops flashing/flickering
        bs = display.getCanvas().getBufferStrategy();
        //If canvas doesn't currently have a buffer
        if(bs == null){
            display.getCanvas().createBufferStrategy(3); //Number of buffers
            return;
        }

        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, height);
        //Drawing to the screen here

        g.drawImage(Assets.player, x,0,null);


        //Finished drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        int fps = 60; //sets the frames per second
        double updateTime = 1000000000 / fps; //amount of times we run the loop per second
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //Amount of time in nanoseconds the computer is running at
        long timer = 0;
        int updates = 0;
        /*
        GAME LOOP!
        1. UPDATE ALL VARIABLES, POSITION OF OBJECTS ...
        2. RENDER AND DRAW THINGS TO THE SCREEN THEN RESTART
         */

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / updateTime; //Amount of time passed since the code was last called, divided by amount of time allowed
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                render();
                updates++;
                delta --; //back to zero for the new check
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + updates);
                updates = 0;
                timer = 0;
            }

        }

        stop();

    }

    public synchronized void start() {
        if (isRunning) {

            return;

        } else {
            isRunning = true;
            thread = new Thread(this);
            thread.start();

        }
    }

    public synchronized void stop() {

        if (!isRunning) {

            return;
        } else {
            isRunning = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
