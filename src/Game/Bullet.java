/**
 * Placeholder for a bullet object that will be made for future milestones, allowing the walker
 * to shoot the enemies who guard the coins
 */



package Game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;

import java.awt.*;



public class Bullet extends DynamicBody {


    public Bullet(World world){
        super(world, new CircleShape(.5f));
        setFillColor(Color.red);

    }



}
