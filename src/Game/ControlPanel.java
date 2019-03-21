package Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel implements ChangeListener {
    public ControlPanel() {
        super();
        this.add(new JButton("EXIT"));
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.exit(0);
    }
}