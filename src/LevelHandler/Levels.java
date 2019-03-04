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


    public void populateWorld(Game game){
        walkingMan = new WalkingMan(this,100,100);
        walkingMan.setPosition(startPos());
        Portal portal = new Portal(this);
        portal.setPosition(portalPos());
        portal.addCollisionListener(new PortalListener(game));

    }

    public abstract Vec2 portalPos();

    public abstract Vec2 startPos();

    public abstract boolean levelCompletion();
}
