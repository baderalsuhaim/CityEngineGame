package LevelHandler;

import Game.Game;
import Game.Coins;
import Listeners.CoinPickup;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class LevelTwo extends Levels {
    private static final int COINS = 8;


    public LevelTwo(Game game){
        super();
    }
    @Override
        public void fillWorld(Game game){
        super.fillWorld(game);

        String backgroundPath = "./data/Backgrounds/cityBGL2.gif";
        Image background = new ImageIcon(backgroundPath).getImage();
        game.getGameView().setBackground(background);


        Shape shape = new BoxShape(500, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.addImage(new BodyImage("data/Objects/1x1-00000000.png"));


        Shape platform1Shape = new BoxShape(4, .5f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-10, 3.5f));

        //make a platform
        Shape platform2Shape = new BoxShape(10,.5f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(10,-4.5f));

        Shape platform3Shape = new BoxShape(8,.5f);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(-35,-4.5f));

        Shape platform4Shape = new BoxShape(8,.5f);
        Body platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-35,3.5f));



    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(-10.4f, -10f);
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(1, -10);
    }


    @Override
    public boolean levelCompletion(){
        return getWalkingMan().getCoinCount() == 4;
    }
}




