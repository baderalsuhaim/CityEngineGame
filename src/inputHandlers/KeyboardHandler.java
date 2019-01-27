package inputHandlers;

import city.cs.engine.*;
import game.WalkingMan;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;


public class KeyboardHandler extends KeyAdapter {
    private static final float WALKING_SPEED = 4;
    private World world;
    private UserView userView;
    private Walker walkerObj;



    public KeyboardHandler (World world, UserView userView){
        this.world = world;
        this.userView = userView;
        walkerObj = new WalkingMan(world, 100,100);

    }

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A) {
            walkerObj.startWalking(-WALKING_SPEED);

        } else if (code == KeyEvent.VK_D){
            walkerObj.startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_W){
            walkerObj.jump(6f);
        }
    }

    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            walkerObj.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            walkerObj.stopWalking();
        }

    }


}
