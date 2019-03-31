package Game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private WalkingMan walkingMan;
    private Image background;

    public GameView(World world, WalkingMan walkingMan, int width, int height) {
        super(world, width, height);
        this.walkingMan = walkingMan;
    }


    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.white);
        g.drawString("COIN COUNT: " + walkingMan.getCoinCount(), (getWidth()/2) - 50, 20);


    }

    public void setBackground(Image background) {
        this.background = background;
    }

}