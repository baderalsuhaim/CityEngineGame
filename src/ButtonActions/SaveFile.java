package ButtonActions;

import java.awt.event.ActionEvent;
import Listeners.ScoreWriter;
import Game.WalkingMan;
import LevelHandler.Levels;
import java.awt.event.ActionListener;
import java.io.IOException;


public class SaveFile implements ActionListener {
    private Levels world;
    private WalkingMan walkingMan;

    public SaveFile(Levels world, WalkingMan walkingMan) {
        this.world = world;
        this.walkingMan = walkingMan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ScoreWriter controller = new ScoreWriter(this.world, this.walkingMan);
        try {
            controller.saveFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}