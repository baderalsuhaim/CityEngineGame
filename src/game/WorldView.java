package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Collisions.Coins;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class WorldView extends World {

    public WorldView() {
        super(60);

        // make the ground
        Shape shape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.red);

        // make a platform
        Shape platform1Shape = new BoxShape(4, .5f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-5, 3.5f));

        Shape platform2Shape = new BoxShape(10,.5f);
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(10,-4.5f));

        //make a coin
        Body coin = new Coins(this);
        coin.setPosition(new Vec2(6, -10));

        //make a coin
        Body coin2 = new Coins(this);
        coin2.setPosition(new Vec2(10, -10));

        //make a coin
        Body coin3 = new Coins(this);
        coin3.setPosition(new Vec2(10, -3.5f));

        //make a coin
        Body coin4 = new Coins(this);
        coin4.setPosition(new Vec2(-5, 4.5f));






    }
}


