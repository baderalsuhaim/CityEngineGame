package LevelHandler;

import Game.Game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelThree extends Levels {

    public LevelThree(Game game){
        super();
    }

    @Override
    public void fillWorld(Game game){
        super.fillWorld(game);

        String backgroundPath = "./data/Backgrounds/cityBGL3.gif";
        Image background = new ImageIcon(backgroundPath).getImage();
        game.getGameView().setBackground(background);

        Shape shape = new BoxShape(500, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.addImage(new BodyImage("data/Objects/1x1-00000000.png"));

        // make a platform
        Shape platform1Shape = new BoxShape(4, .5f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-5, 3.5f));

        Shape platform2Shape = new BoxShape(10,.5f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(10,-4.5f));




    }


    @Override
    public Vec2 portalPosition() {
        return new Vec2(-10.4f, -10f);
    }

    @Override
    public Vec2 startPosition(){
        return new Vec2(1, -10);
    }

    @Override
    public boolean levelCompletion(){
        return getWalkingMan().getCoinCount() == 4;
    }
}




