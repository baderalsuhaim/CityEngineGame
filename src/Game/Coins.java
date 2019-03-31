/**
 * A class for making the coin object that the main walker needs to collect
 */

package Game;

import LevelHandler.Levels;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Coins extends DynamicBody {

    private static SoundClip pickupSound;

    // add sound when picking app coin
    static {
        try {
            pickupSound = new SoundClip("data/Sounds/402288__mattix__retro-coin-02.wav");
            pickupSound.setVolume(.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);

        }
    }

    //makes the coin object
    public Coins(Levels world){
        super(world, new BoxShape(.9f,.9f));
        new AttachedImage
                (this, new BodyImage("data/Objects/Coin.gif"),2f,0,new Vec2(0,0));

    }

    // override the destroy method so when a coin is picked up the sound is played
    @Override
    public void destroy(){
        pickupSound.play();
        super.destroy();
    }



}
