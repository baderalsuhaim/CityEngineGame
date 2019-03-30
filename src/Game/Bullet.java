package Game;

import LevelHandler.Levels;
import city.cs.engine.CircleShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.awt.*;



public class Bullet extends DynamicBody implements CollisionListener {

    public Bullet(Levels world){
        super(world, new CircleShape(.1f));
        setFillColor(Color.red);
        setAngularVelocity(0);
        setLinearVelocity(new Vec2(-70,0));
    }

    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() instanceof Bullet){
            e.getReportingBody().destroy();
            e.getOtherBody().destroy();

        }
    }

}
