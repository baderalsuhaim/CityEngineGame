package LevelHandler;

import Game.Main;
import city.cs.engine.World;
import Game.Portal;
import Listeners.PortalListener;
import Game.WalkingMan;
import org.jbox2d.common.Vec2;

/**
 * Main level handling class, which directly extends the World
 * Each Level class (LevelOne, LevelTwo, etc..) extends this class.
 * It defines functions for filling the world with the player, creating the player, and filling the world with portals and listeners.
 * It also defines abstract functions for start position of the player and position of the portal, and for level completion which is overwritten in each of the level classes.
 */

public abstract class Levels extends World {
    private WalkingMan walkingMan;
    private World world;

    Levels(){
        super(60);
    }

    /**
     * Function for creating the player, which is called inside the main and level classes.
     *
     * @param game the current game process
     */
    public void createPlayer(Main game) {
        if(this.walkingMan != null) {
            this.walkingMan.destroy();
        }
        this.world = game.getWorld();
        this.walkingMan = new WalkingMan(world, 100, 100);
    }

    // method for populating the world
    public void fillWorld(Main game){
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
