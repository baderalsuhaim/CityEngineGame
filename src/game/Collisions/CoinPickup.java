package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import game.WalkingMan;

public class CoinPickup implements CollisionListener {

    private WalkingMan walkingMan;
    private StaticBody ground;

    public CoinPickup(WalkingMan walkingMan){
        this.walkingMan = walkingMan;
    }


    @Override
    public void collide(CollisionEvent e){
        System.out.println(e.getOtherBody());
        if(e.getOtherBody() instanceof Coins){
            e.getOtherBody().destroy();
            walkingMan.incrementCoinCount();
        }
    }


}





