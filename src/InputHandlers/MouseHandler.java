package InputHandlers;

import Game.Bullet;
import Game.WalkingMan;
import LevelHandler.Levels;
import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {


    private Levels world;


    public MouseHandler(Levels world){
        this.world = world;
    }

    @Override
    public void mousePressed(MouseEvent e){

        Bullet bullet = new Bullet(world);
        bullet.setPosition(world.getWalkingMan().getPosition());


    }

}


