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
        up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
        down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
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
