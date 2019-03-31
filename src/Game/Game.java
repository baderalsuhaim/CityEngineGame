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
    private double volume;
    /** Initialise a new Game. */
    public Game() {

        // Make the world
        level = 1;
        world = new LevelOne(this);

        /* Making the background music. The code first tries to run code in the try {}, and if any of the exceptions defined in
         the catch {} occur, it prints the error to the console instead of crashing the game or throwing an exception */
        try {
            backgroundMusic = new SoundClip("data/Sounds/PimPoyPocket.wav"); // Open the audio file from the path given
            this.volume = .02d;
            backgroundMusic.setVolume(volume); // Set its volume to .02
            backgroundMusic.loop();  // Makes the audio loop forever
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e); // Print the error to the console
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
        frame.add(new ControlPanel(world, world.getWalkingMan()), BorderLayout.NORTH);
        frame.pack();

        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // Starts the world and prints welcome commands
        world.start();
        System.out.println("LEVEL 1 STARTING..");
        System.out.println("COLLECT ALL THE COINS TO PROGRESS TO LEVEL 2");
        System.out.println();

    }

    // A accessor method to return the current level
    public int getLevel(){
        return this.level;
    }

    public double getVolume(){
        return this.volume;
    }

    public void setVolume(double vol){
        this.volume = vol;
        this.backgroundMusic.setVolume(vol);
    }

    /* A boolean that checks whether the current level is completed, which returns the levelCompletion function from the common
    Levels class, and which is defined in each individual level by @Override */
    public boolean currentLevelCompleted(){
        return world.levelCompletion();
    }

    /**
     * A function to progress levels upon completion of each level's goals. It stops the current world, and increases the current level,
     * fills the new world with platforms, ground, coins etc. and assigns all the listeners and player to the new world.
     * When the last level, level 3 is completed, it exits the game.
     */
    public void progressLevel(){
        world.stop();
        // executes this block if current level is one
        if (level == 1){
            level++; // increase the level
            world = new LevelTwo(this); // make level two the new world
            world.createPlayer(this); // create the player inside the world
            world.fillWorld(this); // fill the world with platforms, coins, etc...
            view.setWorld(world); // set the view to the current world
            keyboardHandler.defineWalker(world.getWalkingMan()); // add the player to the keyboard listener
            System.out.println("LEVEL 2 STARTING.."); // print out the console output
            world.addStepListener(new FollowPlayer(view, world.getWalkingMan())); // add the step listener to make the camera follow the player
            world.start(); // start the world
            // executes this block if current level is two
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
            // executes this block if current level is three, and exits the game, as level three is the last level
        }  else {
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