package inputHandlers;

import city.cs.engine.*;
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



    /*
     * @param world the world that the keyboard input will be sent to
     * @param userView the view that the keyboard input will be sent to
     */


    public KeyboardHandler (World world, UserView userView){
        this.world = world;
        this.userView = userView;
        walkerObj = new Walker(world, new CircleShape(6));
        walkerObj.setPosition(new Vec2(1,-10));
        walkerObj.setFillColor(Color.red);

    }

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_1) {
            walkerObj.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_2){
            walkerObj.startWalking(WALKING_SPEED);
        }
    }

    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_1){
            walkerObj.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            walkerObj.stopWalking();
        }

    }

}
