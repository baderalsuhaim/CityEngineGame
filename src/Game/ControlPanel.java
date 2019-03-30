package Game;

import ButtonActions.ControlsButton;
import ButtonActions.QuitGame;
import LevelHandler.Levels;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ControlPanel extends JPanel implements ChangeListener {

    private JButton controlsButton;
    private JButton quitButton;

    public ControlPanel(Levels world) {
        super();
        this.quitButton = new JButton("Quit");
        this.quitButton.addActionListener(new QuitGame());
        this.controlsButton = new JButton("Controls");
        this.controlsButton.addActionListener(new ControlsButton());
        this.add(this.controlsButton).setFocusable(false);
        this.add(this.quitButton).setFocusable(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.repaint();
    }
}