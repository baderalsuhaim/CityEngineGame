package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import inputHandlers.KeyboardHandler;
import inputHandlers.MouseHandler;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;
import java.awt.*;

/**
 * A world with some bodies.
 */

public class Game {

    /** The World in which the bodies move and interact. */
    private World world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        world = new World();

        // make the ground
        Shape shape = new BoxShape(20, 0.5f);
        Body ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(Color.red);

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(world, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));

        // make a view
        view = new UserView(world, 500, 500);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(view));

        // display the view in a frame
        final JFrame frame = new JFrame("Basic world");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // adds the key listener so it listens for key input
        frame.addKeyListener(new KeyboardHandler(world, view));
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

      new Game();
    }
}
