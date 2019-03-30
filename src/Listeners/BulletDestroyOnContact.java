/* package Listeners;

import Game.Bullet;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BulletDestroyOnContact implements CollisionListener {

    private Bullet bullet;

    public BulletDestroyOnContact(Bullet bullet){
        this.bullet = bullet;
    }

    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == bullet){
            e.getReportingBody().destroy();

        }
    }

}

 */
