package game;

import city.cs.engine.*;

public class WalkingMan extends Walker {

    private int health;
    private int stamina;


    public WalkingMan(World world, int health, int stamina) {


        super(world, new CircleShape(3));
        this.health = health;
        this.stamina = stamina;

    }


    public int getHealth(){
        return health;
    }

    public int getStamina(){
        return stamina;
    }


}
