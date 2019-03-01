package Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Game.Game;
import Game.WalkingMan;

public class PortalListener implements CollisionListener {
    private Game game;

    public PortalListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        WalkingMan walkingMan = game.getWalkingMan();
        if (e.getOtherBody() == walkingMan && game.currentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.progressLevel();
        }
    }
}

