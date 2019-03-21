package Listeners;

import Game.WalkingMan;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


public class ObstacleListener implements CollisionListener {

    private WalkingMan walkingMan;


    public ObstacleListener(WalkingMan walkingMan){
        this.walkingMan = walkingMan;
    }


    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == walkingMan){
            walkingMan.decreaseLife();
            walkingMan.isWalkerDead();
        }
    }

}
