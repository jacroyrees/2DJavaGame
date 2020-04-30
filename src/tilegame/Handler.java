package tilegame;

import Map.Map;
import UserIO.KeyManager;
import UserIO.MouseManager;
import graphics.Camera;

public class Handler {



    private Game game;
    private Map map;
    public Handler(Game game){
        this.game = game;
    }


    public Camera getGameCamera(){
        return game.getGameCamera();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }





}
