package HUD;

import Entities.Creatures.Player;
import Entities.Entity;
import tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;

public class HUDManager {
    private Handler handler;
    private ArrayList<HUD> hud;
    private Player player;

    public HUDManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        hud = new ArrayList<>();



    }



    public void update(){
        for(int i = 0; i < hud.size(); i++){
            HUD h = hud.get(i);
            h.update();
        }


    }
    public void render(Graphics g){
        for(HUD h : hud) {
            h.render(g);
            //System.out.println(Player.hp);
        }

    }

    public void addHUD(HUD h){
        hud.add(h);
    }


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }





    public ArrayList<HUD> getHuds() {
        return hud;
    }

    public void setHUDs(ArrayList<HUD> entities) {
        this.hud = entities;
    }


}
