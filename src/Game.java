public class Game implements Runnable {

    private Display display;

    public int width, height;
    public String title;

    private boolean isRunning = false;

    private Thread thread;

    public Game(String title, int width, int height) {

        this.width = width;
        this.height = height;
        this.title = title;

        display = new Display(title, width, height);


    }

    private void init() {

        display = new Display(title, width, height);

    }

    private void update() {

    }

    private void render() {

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
