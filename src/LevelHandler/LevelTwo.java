package LevelHandler;

import Game.Game;
import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class LevelTwo extends Levels {

    @Override
        public void populateWorld(Game Game){
        super.populateWorld(Game);


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




    }


    @Override
    public Vec2 portalPos() {
        return new Vec2(-10.4f, -9.6f);
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




