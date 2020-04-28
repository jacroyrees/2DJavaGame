package Map;

import Tile.Tile;

import java.awt.*;

public class Map {

    private int width, height;
    private int[][] tiles;

    public Map(String fileUrl) {

        loadWorld(fileUrl);

    }

    public void update() {

    }

    public void render(Graphics g) {
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTile(x, y).render(g, x * getTile(x, y).TILE_WIDTH, y * getTile(x, y).TILE_HEIGHT);
            }
        }

    }

    public Tile getTile(int x, int y){
        Tile tile = Tile.tiles[tiles[x][y]];
        if(tile == null){
            return Tile.mudTile;
        }else{
            return tile;
        }
    }

    private void loadWorld(String fileUrl) {
        width = 32;
        height = 32;
        tiles = new int[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = 0;

            }
        }
    }
}
