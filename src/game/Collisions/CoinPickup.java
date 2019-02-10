/**
 * Coin pickup functionality to the game
 */


package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import game.WalkingMan;

public class CoinPickup implements CollisionListener {

    private WalkingMan walkingMan;

    public CoinPickup(WalkingMan walkingMan){
        this.walkingMan = walkingMan;
    }


    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() instanceof Coins){
            e.getOtherBody().destroy();
            walkingMan.incrementCoinCount();
        }
    }


}




