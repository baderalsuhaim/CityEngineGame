package Game;

import InputHandlers.KeyboardHandler;
import LevelHandler.LevelOne;
import LevelHandler.Levels;
import city.cs.engine.*;
//import Game.inputHandlers.MouseHandler;

import javax.swing.JFrame;

/**
 * A world with some bodies.
 */

public class Game {

    /** The World in which the bodies move and interact. */
    private Levels world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;

    private int level;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        level = 1;
        world = new LevelOne();
        world.populateWorld(this);


        // make a view
        view = new UserView(world, 500, 500);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add mouse listener
        //view.addMouseListener(new MouseHandler(view));

        // display the view in a frame
        final JFrame frame = new JFrame("Peter's Game");

        // quit the application when the Game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // adds the key listener so it listens for key input
        KeyboardHandler keyboardHandler = new KeyboardHandler(world, view);
        frame.addKeyListener(keyboardHandler);

        // size the Game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    public WalkingMan getWalkingMan() {
        return world.getWalkingMan();
    }

    public boolean currentLevelCompleted(){
        return world.levelCompletion();
    }

    public void progressLevel(){
        world.stop();
        if (level == 3){
            System.exit(0);
            System.out.println("Game finished!");
        }   else if (level == 1) {
            level++;
            //world = new LevelTwo();
            world.populateWorld(this);
            view.setWorld(world);
            world.start();


        }

    }


    /** Run the Game. */
    public static void main(String[] args) {

      new Game();

    }
}
