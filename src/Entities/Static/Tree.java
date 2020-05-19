package Entities.Static;

import Tile.Tile;
import graphics.Assets;
import tilegame.Handler;

import java.awt.*;
import java.util.Random;

public class Tree extends StaticEntity {
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2);
        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 2.f);

    }

    Random random = new Random();
    private int randomTree = random.nextInt(Assets.tree.size());
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree.get(randomTree),(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), null);
    }
}
