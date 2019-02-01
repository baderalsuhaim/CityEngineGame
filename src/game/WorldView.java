package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Collisions.Coins;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class WorldView extends World {

    private StaticBody ground;

    public WorldView(){
        super(60);

        // make the ground
        Shape shape = new BoxShape(20, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.red);

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));

        Body coin = new Coins(this);
        coin.setPosition(new Vec2(6,-10));

        Body coin2 = new Coins(this);
        coin2.setPosition(new Vec2(10,-10));

    }

    public StaticBody getGround() {
        return ground;
    }
}
