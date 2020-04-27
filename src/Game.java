import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;

    public int width, height;
    public String title;

    private boolean isRunning = false;

    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {

        this.width = width;
        this.height = height;
        this.title = title;



    }

    private void init() {

        display = new Display(title, width, height);

    }

    private void update() {

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
        //Drawing to the screen here
        g.fillRect(0, 0, width, height);
        //Finished drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        /*
        GAME LOOP!
        1. UPDATE ALL VARIABLES, POSITION OF OBJECTS ...
        2. RENDER AND DRAW THINGS TO THE SCREEN THEN RESTART
         */

        while (isRunning) {

            update();
            render();

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
