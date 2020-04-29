package Map;

import Tile.Tile;
import Utilities.Utilities;

import java.awt.*;

public class Map {

    private int width, height;
    private int[][] tiles;
    private int spawnX, spawnY;
    private String fileURL;

    public Map(String fileUrl) {
        this.fileURL = fileUrl;
        loadWorld(fileUrl);

    }

    public void update() {

    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * getTile(x, y).TILE_WIDTH, y * getTile(x, y).TILE_HEIGHT);
            }
        }

    }

    public Tile getTile(int x, int y) {
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
}


