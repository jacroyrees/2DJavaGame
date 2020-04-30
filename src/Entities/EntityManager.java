package Entities;

import Entities.Creatures.Player;
import tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private Handler handler;


    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        addEntity(player);

    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void update(){
        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.update();
        }

    }

    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }

    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    private Player player;
    private ArrayList<Entity> entities;





}
