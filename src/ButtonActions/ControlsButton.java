package ButtonActions;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Game.Game;

import javax.swing.*;

public class ControlsButton extends JPanel implements ActionListener {
    Component frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "JUMP: W / ARROW UP\n" +
                "MOVE RIGHT: D / ARROW RIGHT\n" +
                "MOVE LEFT: A / ARROW LEFT\n" +
                "SHOOTING: LEFT MOUSE BUTTON", "Controls", JOptionPane.INFORMATION_MESSAGE);

    }
}