/**
 * Placeholder for a bullet object that will be made for future milestones, allowing the walker
 * to shoot the enemies who guard the coins
 */



package game.Collisions;

import city.cs.engine.*;
import game.WalkingMan;
import inputHandlers.KeyboardHandler;
import org.jbox2d.common.Vec2;
import java.awt.Color;



public class Bullet extends DynamicBody {


    public Bullet(World world){
        super(world, new CircleShape(.5f));
        setFillColor(Color.red);

    }



}
