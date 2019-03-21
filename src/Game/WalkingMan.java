package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


import javax.swing.*;
import java.awt.*;


public class WalkingMan extends Walker {


    private int health;
    private int stamina;
    private int coinCount;
    Component frame;


    public WalkingMan(World world, int health, int stamina) {

        super(world, new PolygonShape(-0.744f,-1.026f, -0.933f,0.651f,
                -0.276f,1.11f, 0.288f,1.062f, 1.002f,0.468f,
                0.798f,-0.474f, 0.546f,-1.086f, -0.741f,-1.047f));
                this.stamina = stamina;
                this.health = health;
                addImage(new BodyImage("data/Animations/idle.gif",
                        2.5f));
                coinCount = 0;


    }


    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        this.removeAllImages();
        AttachedImage img = new AttachedImage(this, new BodyImage("data/Animations/run.gif",
                2.5f), 1f, 0, new Vec2(0, 0));

        if(speed < 0) {
            img.flipHorizontal();
        }
    }

    @Override
    public void stopWalking(){
        super.stopWalking();
        this.removeAllImages();
        this.addImage(new BodyImage("data/Animations/idle.gif",
                2.5f));
    }





    // returns the value of health
    public int getHealth(){
        return this.health;
    }
    //returns the value of stamina
    public int getStamina(){
        return this.stamina;
    }
    //returns the value of coin count
    public int getCoinCount(){
        return this.coinCount;
    }



    public void incrementCoinCount(){
        coinCount++;
        System.out.println("COIN COUNT: " + coinCount);
    }

    public void decreaseLife(){
        health = health - 10;
        stamina = stamina - 10;
        System.out.println("Health: " + getHealth());
        System.out.println("Stamina: " + getStamina());

    }

    public void isWalkerDead(){
        if(getHealth() == 0 && getStamina() == 0){
            JOptionPane.showMessageDialog(frame, "Game over", "Game over", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }



}