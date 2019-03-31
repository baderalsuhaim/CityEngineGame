package ButtonActions;

import java.awt.event.ActionEvent;
import Listeners.ScoreWriter;
import Game.WalkingMan;
import Game.Game;
import LevelHandler.Levels;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;

public class LoadFile implements ActionListener {
    private Levels world;
    private Game game;
    private WalkingMan walkingMan;

    public LoadFile(Levels world, WalkingMan walkingMan, Game game) {
        this.world = world;
        this.walkingMan = walkingMan;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser loadDialog = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".CSV Files", "csv");
        loadDialog.setFileFilter(filter);
        int returnVal = loadDialog.showOpenDialog(this.game.getGameView());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = loadDialog.getSelectedFile().getAbsolutePath();
            ScoreWriter saveLoad = new ScoreWriter(this.world, this.walkingMan);
            saveLoad.loadFile(fileName);
        }
    }
}

