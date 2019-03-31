package Game;

import ButtonActions.ControlsButton;
import ButtonActions.QuitGame;
import ButtonActions.SaveFile;
import ButtonActions.LoadFile;
import LevelHandler.Levels;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ControlPanel extends JPanel implements ChangeListener {

    private JButton controlsButton;
    private JButton quitButton;
    private JButton loadButton;
    private JButton saveButton;

    public ControlPanel(Levels world, WalkingMan walkingMan) {
        super();
        this.quitButton = new JButton("Quit");
        this.quitButton.addActionListener(new QuitGame());

        this.controlsButton = new JButton("Controls");
        this.controlsButton.addActionListener(new ControlsButton());

        this.loadButton = new JButton("Load File");
        this.loadButton.addActionListener(new LoadFile(world, walkingMan));

        this.saveButton = new JButton("Save File");
        this.saveButton.addActionListener(new SaveFile(world, walkingMan));

        this.add(this.controlsButton).setFocusable(false);
        this.add(this.quitButton).setFocusable(false);
        this.add(this.loadButton).setFocusable(false);
        this.add(this.saveButton).setFocusable(false);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.repaint();
    }
}