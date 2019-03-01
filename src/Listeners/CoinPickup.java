/**
 * Coin pickup functionality to the Game
 */


package Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Game.Coins;
import Game.WalkingMan;

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




