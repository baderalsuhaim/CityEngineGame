package inputHandlers;

import city.cs.engine.*;
//import game.Collisions.Bullet;
import game.Collisions.CoinPickup;
import game.WalkingMan;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




public class KeyboardHandler extends KeyAdapter  {
    private static final float WALK_SPEED = 6;
    private World world;
    private UserView userView;
    private WalkingMan walkerObj;
    //private Bullet bullet;


    public KeyboardHandler (World world, UserView userView){
        this.world = world;
        this.userView = userView;
        walkerObj = new WalkingMan(world, 100,100);
        walkerObj.setPosition(new Vec2(1,-10));
        walkerObj.addCollisionListener(new CoinPickup(walkerObj));
        walkerObj.setGravityScale(3);

    }

    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A) {
            walkerObj.startWalking(-WALK_SPEED);
        } else if (code == KeyEvent.VK_D){
            walkerObj.startWalking(WALK_SPEED);
        } else if (code == KeyEvent.VK_W){
            walkerObj.jump(23f);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            walkerObj.stopWalking();
            walkerObj.setLinearVelocity(new Vec2(0,0));
        } else if (code == KeyEvent.VK_D) {
            walkerObj.stopWalking();
            walkerObj.setLinearVelocity(new Vec2(0,0));
        }

    }

    public WalkingMan getWalkerObj() {
        return walkerObj;
    }
}
