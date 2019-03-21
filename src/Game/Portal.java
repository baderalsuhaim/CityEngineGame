package Game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Portal extends StaticBody {

    public Portal(World world){
        super(world, new BoxShape(1f, 1f));
        addImage(new BodyImage("data/Objects/p2.gif",2f));

    }


}

