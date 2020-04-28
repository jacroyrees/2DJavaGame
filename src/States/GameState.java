package States;

import graphics.Assets;

import java.awt.*;

public class GameState extends State{

public GameState(){

}


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, 0, 0, null);
    }
}
