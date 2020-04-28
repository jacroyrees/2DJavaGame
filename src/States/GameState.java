package States;

import Entities.Creatures.Creature;
import Entities.Creatures.Player;
import Map.Map;
import graphics.Assets;
import tilegame.Game;

import java.awt.*;

public class GameState extends State {


    private Player player;
    private Map map;

    public GameState(Game game) {
        super(game);
        player = new Player(game,0, 0, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 10);
        map = new Map("");
    }


    @Override
    public void update() {

        map.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {

        map.render(g);
        player.render(g);
    }
}
