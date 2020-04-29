package States;

import Entities.Creatures.Creature;
import Entities.Creatures.Player;
import Map.Map;

import Sounds.Sounds;
import tilegame.Handler;

import java.awt.*;

public class GameState extends State {


    private Player player;
    private Map map;
    private Sounds sounds;
    public GameState(Handler handler) {
        super(handler);

        map = new Map(handler, "src/res/Level/Level1");
        handler.setMap(map);
        player = new Player(handler,200, 200, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 10);


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
