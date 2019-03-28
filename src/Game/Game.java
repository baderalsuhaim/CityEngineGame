package Game;

import InputHandlers.KeyboardHandler;
import LevelHandler.LevelOne;
import LevelHandler.LevelThree;
import LevelHandler.LevelTwo;
import LevelHandler.Levels;
import Listeners.FollowPlayer;
import city.cs.engine.SoundClip;

import java.awt.*;

//import Game.inputHandlers.MouseHandler;

import javax.swing.*;

/**
 * A world with some bodies.
 */

public class Game {

    /** The World in which the bodies move and interact. */
    private Levels world;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private int level;
    private KeyboardHandler keyboardHandler;

    private SoundClip backgroundMusic;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        level = 1;
        world = new LevelOne(this);

        world.createPlayer(this);

        // adds the key listener so it listens for key input
        keyboardHandler = new KeyboardHandler(world.getWalkingMan());

        view = new GameView(world, world.getWalkingMan(), 960, 640);

        world.fillWorld(this);

        // display the view in a frame
        JFrame frame = new JFrame("Game");
        frame.addKeyListener(keyboardHandler);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add mouse listener
        //view.addMouseListener(new MouseHandler(view));


        // quit the application when the Game window is closed

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window

        frame.add(view, BorderLayout.CENTER);
        frame.pack();


        // add buttons
        //frame.add(new ControlPanel(), BorderLayout.SOUTH);
        //frame.pack();

        // following the player
        world.addStepListener(new FollowPlayer(view, world.getWalkingMan()));

        // size the Game window to fit the world view


        // make the window visible
        frame.setVisible(true);

        //ControlPanel buttons = new ControlPanel();
        //frame.add(buttons.getMainPanel(), BorderLayout.CENTER);

        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
        System.out.println("LEVEL 1 STARTING..");
        System.out.println("COLLECT ALL THE COINS TO PROGRESS TO LEVEL 2");
        System.out.println();
    }

    public int getLevel(){
        return this.level;
    }

    public boolean currentLevelCompleted(){
        return world.levelCompletion();
    }


    //function to progress levels upon completion of each level's goals
    public void progressLevel(){
        world.stop();
        if (level == 1){
            level++;
            world = new LevelTwo(this);
            world.createPlayer(this);
            world.fillWorld(this);
            view.setWorld(world);
            keyboardHandler.defineWalker(world.getWalkingMan());
            System.out.println("LEVEL 2 STARTING..");
            world.addStepListener(new FollowPlayer(view, world.getWalkingMan()));
            world.start();
        }   else if (level == 2) {
            level++;
            world = new LevelThree(this);
            world.createPlayer(this);
            world.fillWorld(this);
            view.setWorld(world);
            keyboardHandler.defineWalker(world.getWalkingMan());
            System.out.println("LEVEL 3 STARTING..");
            world.addStepListener(new FollowPlayer(view, world.getWalkingMan()));
            world.start();
        } else {
            System.out.println("Game finished!");
            System.exit(0);

        }

    }

    public GameView getGameView() {
        if(view == null){
            System.out.println("Null boy");
            System.exit(0);
        }
        return view;
    }

    public Levels getWorld() {
        return world;
    }

    /** Run the Game. */
    public static void main(String[] args) {
      new Game();
    }
}
