package States;

import Entities.Creatures.Creature;
import Entities.Creatures.Player;
import Entities.Static.Tree;
import Map.Map;

import Sounds.Sounds;
import javafx.scene.media.MediaPlayer;
import tilegame.Handler;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.io.File;

public class GameState extends State {





    private Map map;




    public GameState(Handler handler) {
        super(handler);


        map = new Map(handler, "src/res/Level/Level1");
        handler.setMap(map);





    }


    @Override
    public void update() {

        map.update();


    }

    @Override
    public void render(Graphics g) {

        map.render(g);


    }
}
