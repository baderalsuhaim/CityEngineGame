package Listeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Game.Game;

import city.cs.engine.Walker;

public class PortalListener implements CollisionListener {
    private Game game;

    public PortalListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Walker ) {
            System.out.println("Congratulations! You finished level " + game.getLevel() + "!");
            game.progressLevel();
        }
    }
}

