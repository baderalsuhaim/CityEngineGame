package Game;

import city.cs.engine.*;

public class Portal extends StaticBody {

    public Portal(World world){
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/Objects/p2.gif",1f));

    }
}
