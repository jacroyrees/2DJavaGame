package Map;

import Tile.Tile;
import Utilities.Utilities;
import tilegame.Game;
import tilegame.Handler;

import java.awt.*;

public class Map {
    private Handler handler;
    private int width, height;
    private int[][] tiles;
    private int spawnX, spawnY;
    private String fileURL;


    public Map(Handler handler, String fileUrl) {
        this.fileURL = fileUrl;
        this.handler = handler;
        loadWorld(fileUrl);

    }

    public void update() {

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

    }

    public Tile getTile(int x, int y) {
        if( x < 0 || y < 0 || x >= width || y >= height){
            return Tile.grassTile;
        }
        Tile tile = Tile.tiles[tiles[x][y]];
        if (tile == null) {
            return Tile.mudTile;
        } else {
            return tile;
        }
    }

    private void loadWorld(String fileUrl) {
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


