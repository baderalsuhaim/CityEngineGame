package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Obstacle extends StaticBody {


    public Obstacle(World world){
        super(world, new BoxShape(.4f,.01f));
        new AttachedImage(this, new BodyImage("data/Objects/Spikes.png"),1,0,new Vec2(0,0));
    }
}
