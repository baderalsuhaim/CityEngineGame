package Listeners;

import Game.Game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
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
        } else if (e.getOtherBody() instanceof Walker )  {
            System.out.println("Level not completed! Collect all coins!");
        }
    }
}

