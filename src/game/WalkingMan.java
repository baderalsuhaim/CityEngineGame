package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class WalkingMan extends Walker {


    private int health;
    private int stamina;
    private BodyImage walkImg = new BodyImage("data/Survivor.png");
    private Vec2 vec2 = new Vec2(0,0);
    private AttachedImage walkerImg = new AttachedImage(this, walkImg,2.25f,0f, vec2);



    public WalkingMan(World world, int health, int stamina) {


        super(world, new PolygonShape(-0.744f,-1.026f, -0.933f,0.651f,
                -0.276f,1.11f, 0.288f,1.062f, 1.002f,0.468f,
                0.798f,-0.474f, 0.546f,-1.086f, -0.741f,-1.047f));
        this.health = health;
        this.stamina = stamina;
        //this.addImage(walkerImg.getBodyImage());
        //this.addImage(new BodyImage("data/Survivor.png", 2.25f));

    }

    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        this.removeAllImages();
        AttachedImage img = new AttachedImage(this, new BodyImage("data/Survivor.png", 2.5f), 1, 0, new Vec2(0, 0));

        if(speed < 0) {
            img.flipHorizontal();
        }
    }

    public int getHealth(){
        return health;
    }

    public int getStamina(){
        return stamina;
    }


}