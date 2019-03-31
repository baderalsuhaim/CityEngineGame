package Listeners;

import Game.WalkingMan;
import LevelHandler.Levels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreWriter {
    private Levels world;
    private WalkingMan walkingMan;

    public ScoreWriter(Levels world, WalkingMan walkingMan) {
        this.world = world;
        this.walkingMan = walkingMan;
    }

    public void saveFile() throws IOException {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        String fileName = formatter.format(date) + ".csv";
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(walkingMan.getCoinCount() + "\n");
            writer.write(walkingMan.getHealth() + "\n");
            writer.write(walkingMan.getHealth() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public void loadFile(String fileName) {
        try {
            FileReader fr = null;
            BufferedReader reader = null;
            try {
                int count = 0;
                fr = new FileReader(fileName);
                reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    switch (count) {
                        case 0:
                            this.walkingMan.setScore(Integer.parseInt(line));
                            break;
                        case 1:
                            this.walkingMan.setHealth(Integer.parseInt(line));
                            break;
                        case 2:
                            this.walkingMan.setStamina(Integer.parseInt(line));
                            break;
                        default:
                            System.out.println("Error");
                    }
                    count++;
                    line = reader.readLine();
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}