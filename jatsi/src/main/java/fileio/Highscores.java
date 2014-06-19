package fileio;

import java.util.*;
import java.io.*;

/**
 * Contains methods to load and update the high score list of the game.
 */
public class Highscores {
    
    /**
     * The high score list.
     */
    private ArrayList<Highscore> highscores;
    
    /**
     * The file where the high score list is saved.
     */
    private final String FILE;
        
    /**
     * Input stream for reading from the file.
     */
    ObjectInputStream in = null;
    
    /**
     * Output stream for writing into the file.
     */
    ObjectOutputStream out = null;
    
    /**
     * Class constructor.
     * @param file Filename.
     */
    public Highscores(String file) {
        this.highscores = new ArrayList<>();
        this.FILE = file;
    }
    
    /**
     * Reads the high score list from the file given in the constructor.
     * @throws Exception
     */
    private void readFile() throws Exception {
        in = new ObjectInputStream(new FileInputStream(FILE));
        highscores = (ArrayList<Highscore>) in.readObject();
        if (in != null) {
            in.close();
        }
    }
    
    /**
     * Writes the high score list into the file given in the constructor.
     * @throws Exception
     */
    private void writeFile() throws Exception {
        out = new ObjectOutputStream(new FileOutputStream(FILE));
        out.writeObject(highscores);
        if (out != null) {
            out.close();
        }
    }
    
    /**
     * Sorts the high score list.
     */
    private void sort() {
        Collections.sort(highscores);
    }
    
    /**
     * Adds a new high score into the high score list and saves it.
     * @param name Player's name.
     * @param score Total points.
     */
    public void addScore(String name, int score) {
        try {
            readFile();
        } catch (Exception e) {
            System.err.println("Error while loading high scores: " + e.getMessage());
        }
        highscores.add(new Highscore(name, score));
        sort();
        try {
            writeFile();
        } catch (Exception e) {
            System.err.println("Error while updating high scores: " + e.getMessage());
        }
    }
    
    /**
     * Reads the high score list from the file and returns it.
     * @return High score list.
     */
    public ArrayList<Highscore> getHighscores() {
        try {
            readFile();
        } catch (Exception e) {
            System.err.println("Error while loading high scores: " + e.getMessage());
        }
        sort();
        return highscores;
    }
    
    @Override
    public String toString() {
        String temp = "";
        int max = 10;
        highscores = getHighscores();
        if (highscores.size() < max) {
            max = highscores.size();
        }
        for (int i = 0; i < max; i++) {
            temp += (i+1) + ". " + highscores.get(i).getName() + " " + highscores.get(i).getTotal() + "\n";
        }
        return temp;
    }
    
}
