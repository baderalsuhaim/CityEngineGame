package Game;

import InputHandlers.KeyboardHandler;
import InputHandlers.MouseHandler;
import LevelHandler.LevelOne;
import LevelHandler.LevelThree;
import LevelHandler.LevelTwo;
import LevelHandler.Levels;
import Listeners.FollowPlayer;
import city.cs.engine.SoundClip;


import java.awt.*;
import java.io.IOException;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    private MouseHandler mouseHandler;

    /** Initialise a new Game. */
    public Game() {

        // Make the world
        level = 1;
        world = new LevelOne(this);

        try {
            backgroundMusic = new SoundClip("data/Sounds/PimPoyPocket.wav");   // Open an audio input stream
            backgroundMusic.setVolume(0.02d);
            backgroundMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // Create the player
        world.createPlayer(this);

        // Make a new view
        view = new GameView(world, world.getWalkingMan(), 960, 640);

        // Fill the world with props
        world.fillWorld(this);

        // Display the view in a frame and add the key listener
        JFrame frame = new JFrame("Game");
        keyboardHandler = new KeyboardHandler(world.getWalkingMan());
        frame.addKeyListener(keyboardHandler);

        // Add the mouse listener
        view.addMouseListener(new MouseHandler(getWorld()));

        // Quit the game when window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the view in the window
        frame.add(view, BorderLayout.CENTER);
        frame.pack();

        // Add camera following the player
        world.addStepListener(new FollowPlayer(view, world.getWalkingMan()));

        // Make the window visible
        frame.setVisible(true);

        // Adds the control panel with buttons
        frame.add(new ControlPanel(world), BorderLayout.NORTH);
        frame.pack();

        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // Starts the world and prints welcome commands
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


    /**
     * A function to progress levels upon completion of each level's goals
     */
    public void progressLevel(){
        world.stop();
        if (level == 1){ // if current level is 1
            level++; // increase the level
            world = new LevelTwo(this); // make level two the new world
            world.createPlayer(this); // create the player inside the world
            world.fillWorld(this); // fill the world with platforms, coins, etc...
            view.setWorld(world); // set the view to the current world
            keyboardHandler.defineWalker(world.getWalkingMan()); // add the player to the keyboard listener
            System.out.println("LEVEL 2 STARTING.."); // print out the console output
            world.addStepListener(new FollowPlayer(view, world.getWalkingMan())); // add the step listener to make the camera follow the player
            world.start(); // start the world
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
            System.out.println("Main finished!");
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