package game.Collisions;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;



public class Coins extends DynamicBody {


    public Coins(World world){
        super(world, new BoxShape(.9f,.9f));
        setFillColor(Color.red);
        new AttachedImage(this, new BodyImage("data/Coin.gif"),2f,0,new Vec2(0,0));

    }



}
