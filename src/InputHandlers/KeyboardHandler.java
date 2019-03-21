package InputHandlers;

import city.cs.engine.*;
//import Game.Bullet;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




public class KeyboardHandler extends KeyAdapter {
    private static final float WALK_SPEED = 6;

    private Walker walkerObj;

    public KeyboardHandler(Walker walkerObj) {
        this.walkerObj = walkerObj;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        walkerObj.setGravityScale(4);
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            walkerObj.startWalking(-WALK_SPEED);
        } else if (code == KeyEvent.VK_D) {
            walkerObj.startWalking(WALK_SPEED);
        } else if (code == KeyEvent.VK_W) {
            walkerObj.jump(28f);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            walkerObj.stopWalking();
            walkerObj.setLinearVelocity(new Vec2(0, 0));
        } else if (code == KeyEvent.VK_D) {
            walkerObj.stopWalking();
            walkerObj.setLinearVelocity(new Vec2(0, 0));
        }

    }


    public void defineWalker(Walker walkerObj){
        this.walkerObj = walkerObj;

    }
}


