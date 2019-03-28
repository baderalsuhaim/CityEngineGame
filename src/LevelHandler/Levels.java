package LevelHandler;

import city.cs.engine.World;
import Game.Game;
import Game.Portal;
import Listeners.PortalListener;
import Game.WalkingMan;
import org.jbox2d.common.Vec2;

public abstract class Levels extends World {
    private WalkingMan walkingMan;
    private World world;

    Levels(){
        super(60);
    }

    public void createPlayer(Game game) {
        if(this.walkingMan != null) {
            this.walkingMan.destroy();
        }
        this.world = game.getWorld();
        this.walkingMan = new WalkingMan(world, 100, 100);
    }

    // method for populating the world
    public void fillWorld(Game game){
        //walkingMan = new WalkingMan(this,100,100);
        walkingMan.setPosition(startPosition());
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game));

    }

    public WalkingMan getWalkingMan() {
        return walkingMan;
    }

    //method for determining the position of the portal in each level
    public abstract Vec2 portalPosition();
    //method for  determining the start position of the player in each level
    public abstract Vec2 startPosition();
    //method for setting a level's objectives that the player needs to achieve in order to progress
    public abstract boolean levelCompletion();
}
