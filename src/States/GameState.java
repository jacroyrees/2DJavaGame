package States;

import Entities.Creatures.Creature;
import Entities.Creatures.Player;
import graphics.Assets;
import tilegame.Game;

import java.awt.*;

public class GameState extends State {


    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game,0, 0, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 10);
    }


    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
