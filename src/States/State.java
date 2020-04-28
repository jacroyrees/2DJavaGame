package States;

import tilegame.Game;

import java.awt.*;

public abstract class State {

    private static State currentState = null;


    public static void setState(State state){
        currentState = state;
    }


    public static State getState(){
        return currentState;
    }

    //CLASS

    protected Game game;

    public State(Game game){
        this.game = game;
    }
    public abstract void update();


    //Take in graphics object to pass through so it can draw directly to the screen
    public abstract void render(Graphics g);





}
