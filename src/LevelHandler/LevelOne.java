package LevelHandler;

import Listeners.CoinPickup;
import city.cs.engine.*;
import city.cs.engine.Shape;
import Game.Coins;
import Game.Game;
import org.jbox2d.common.Vec2;


public class LevelOne extends Levels {
    private static final int COINS = 4;


    @Override
    public void populateWorld(Game game) {
        super.populateWorld(game);

        // make the ground
        Shape shape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, .5f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-5, 3.5f));

        Shape platform2Shape = new BoxShape(10,.5f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(10,-4.5f));


        for(int i = 0; i < COINS; i++){
            Body coin = new Coins(this);
            coin.setPosition(new Vec2(i * 4 - 8, 10));
            coin.addCollisionListener(new CoinPickup(getWalkingMan()));
        }


    }

    @Override
    public Vec2 portalPos() {
        return new Vec2(-10.4f, -10f);
    }

    @Override
    public Vec2 startPos(){
        return new Vec2(1, -10);
    }

    @Override
    public boolean levelCompletion(){
        return getWalkingMan().getCoinCount() == 4;
    }
}


