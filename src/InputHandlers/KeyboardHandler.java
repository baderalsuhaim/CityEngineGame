package InputHandlers;

import Game.WalkingMan;
import city.cs.engine.*;
//import Main.Bullet;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Game.Main;

import javax.security.auth.kerberos.KerberosTicket;


public class KeyboardHandler extends KeyAdapter {
    private static final float WALK_SPEED = 8;

    private WalkingMan walkerObj;

    public KeyboardHandler(WalkingMan walkerObj) {
        this.walkerObj = walkerObj;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        walkerObj.setGravityScale(4);
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            walkerObj.startWalking(-WALK_SPEED);
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            walkerObj.startWalking(WALK_SPEED);
        } else if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            walkerObj.jump(28f);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            walkerObj.stopWalking();
            walkerObj.setLinearVelocity(new Vec2(0, 0));
        } else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            walkerObj.stopWalking();
            walkerObj.setLinearVelocity(new Vec2(0, 0));
        }

    }



    public void defineWalker(WalkingMan walkerObj){
        this.walkerObj = walkerObj;

    }

}


