package Game;

import LevelHandler.Levels;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.awt.*;



public class Bullet extends DynamicBody {

    public Bullet(Levels world){
        super(world, new CircleShape(.1f));
        setFillColor(Color.red);
        setAngularVelocity(0);
        setLinearVelocity(new Vec2(-70,0));
    }

}
