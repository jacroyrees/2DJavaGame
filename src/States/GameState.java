package States;

import Entities.Creatures.Player;
import graphics.Assets;
import tilegame.Game;

import java.awt.*;

public class GameState extends State {


    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game,0, 0, 100);
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
