package UserIO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right; //if the keys pressed set them to true

    public KeyManager(){
        keys = new boolean[256];
    }

    public void update(){
        up = keys[KeyEvent.VK_W];
        left = keys[KeyEvent.VK_A];
        down = keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_D];
    }


    //True -> key is pressed

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
        System.out.println("PRESSED!");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

}
