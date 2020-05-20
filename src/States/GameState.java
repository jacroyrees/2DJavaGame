package States;

import Map.Map;
import tilegame.Handler;

import java.awt.*;

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
