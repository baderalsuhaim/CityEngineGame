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
        Shape shape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(world, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));
        
        // add another platform here
        Shape platform2Shape = new BoxShape(4, 0.5f);
        Body platform2 = new StaticBody(world, platform2Shape);
        platform2.setAngle(0.3f);
        platform2.setFillColor(Color.red);
        platform2.setPosition(new Vec2(9, 5.5f));

        // make a character
        Shape birdShape = new PolygonShape(
            0.149f,0.975f, 0.775f,0.193f, 0.772f,-0.099f, 0.401f,-0.928f,
                  -0.36f,-0.922f, -0.719f,-0.025f, -0.725f,0.163f, -0.14f,0.972f);
        Body bird = new DynamicBody(world, birdShape);
        bird.addImage(new BodyImage("data/yellow-bird.gif", 2.25f));
        bird.setPosition(new Vec2(8, -10));

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

        frame.addKeyListener(new KeyboardHandler(world, view));
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        //uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

      new Game();
    }
}
