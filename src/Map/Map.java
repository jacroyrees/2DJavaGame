package Map;


import Entities.Creatures.DullCreature;
import Entities.Creatures.Player;
import Entities.EntityManager;
import Entities.Static.Tree;

import HUD.HUDManager;
import HUD.HealthBar;

import Tile.DirtTiles.DirtTile;
import Tile.GrassTiles.GrassTile;

import Tile.Tile;
import Utilities.Utilities;

import tilegame.Handler;

import java.awt.*;
import java.util.Random;

public class Map {
    private Handler handler;
    private int width, height;
    private int[][] tiles;
    private int spawnX, spawnY;
    private String fileURL;
    private Random random = new Random();
    private Player player;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    public HUDManager getHudManager(){ return hudManager;}

    private EntityManager entityManager;
    private HUDManager hudManager;
    public Map(Handler handler, String fileUrl) {
        this.fileURL = fileUrl;
        this.handler = handler;

        entityManager = new EntityManager(handler, player = new Player(handler, 100, 100, 10));
        hudManager = new HUDManager(handler, player);
        hudManager.addHUD(new HealthBar(handler, 10, 320, player));
      //  640, 360
        entityManager.addEntity(new DullCreature(handler, 300, 600, width, height, 10, player));

        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Tree(handler, 700, 450));
        entityManager.addEntity(new Tree(handler, 650, 150));
        entityManager.addEntity(new Tree(handler, 800, 570));
        entityManager.addEntity(new Tree(handler, 400, 570));
        loadWorld(fileUrl);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }

    public void update() {

        entityManager.update();
        hudManager.update();


    }

    public void render(Graphics g) {
        int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd =  (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_WIDTH);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT +1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, ((x * Tile.TILE_WIDTH) - (int)handler.getGameCamera().getxOffset()), y * Tile.TILE_HEIGHT - (int) handler.getGameCamera().getyOffset());
            }
        }


        entityManager.render(g);
        hudManager.render(g);


    }

    public Tile getTile(int x, int y) {
        if( x < 0 || y < 0 || x >= width || y >= height){
            return new GrassTile(1); // TODO: fix the ID here, i don't really get the system atm
        }
        Tile tile = Tile.tiles[tiles[x][y]];
        if (tile == null) {
            return new DirtTile(2); // TODO: fix ID
        } else {

            return tile;
        }
    }

    private void loadWorld(String fileUrl) {
        this.fileURL = fileUrl;
        String file = Utilities.loadFileAsString(fileURL);
        String[] tokens = file.split("\\s+"); //any space or new line
        width = Utilities.parseInt(tokens[0]);
        height = Utilities.parseInt(tokens[1]);
        spawnX = Utilities.parseInt(tokens[2]);
        spawnY = Utilities.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                //Add 4 due to the first 4 slots being variables
                tiles[x][y] = Utilities.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}


