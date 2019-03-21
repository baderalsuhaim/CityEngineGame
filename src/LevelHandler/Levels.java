package LevelHandler;

import city.cs.engine.World;
import Game.Game;
import Game.Portal;
import Listeners.PortalListener;
import Game.WalkingMan;
import org.jbox2d.common.Vec2;

public abstract class Levels extends World {
    private WalkingMan walkingMan;

    public WalkingMan getWalkingMan() {
        return walkingMan;
    }

    public Levels(){
        super(60);
    }

    // method for populating the world
    public void fillWorld(Game game){
        walkingMan = new WalkingMan(this,100,100);
        walkingMan.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));

    }

    //method for determining the position of the portal in each level
    public abstract Vec2 portalPosition();
    //method for  determining the start position of the player in each level
    public abstract Vec2 startPosition();
    //method for setting a level's objectives that the player needs to achieve in order to progress
    public abstract boolean levelCompletion();
}
