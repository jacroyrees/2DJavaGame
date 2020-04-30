package Map;

import Entities.Creatures.Player;
import Entities.EntityManager;
import Entities.Static.Tree;
import Tile.Tile;
import Utilities.Utilities;
import graphics.Assets;
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

    public EntityManager getEntityManager() {
        return entityManager;
    }

    private EntityManager entityManager;


    public Map(Handler handler, String fileUrl) {
        this.fileURL = fileUrl;
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100, 10));
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

    }

    public Tile getTile(int x, int y) {
        if( x < 0 || y < 0 || x >= width || y >= height){
            return Tile.grassTile;
        }
        Tile tile = Tile.tiles[tiles[x][y]];
        if (tile == null) {
            return Tile.newDirtTile;
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


