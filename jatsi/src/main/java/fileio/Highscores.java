package fileio;

import java.util.*;
import java.io.*;

/**
 * Luokka tarjoaa metodeja, joilla päivitetään jatsi-noppapelin high score -listaa.
 */
public class Highscores {
    
    /**
     * High score -lista.
     */
    private ArrayList<Highscore> highscores;
    
    /**
     * Tiedosto, jossa high score -listaa säilytetään.
     */
    private final String FILE;
    
    /**
     * Output stream tiedostoon kirjoittamista varten.
     */
    ObjectOutputStream out = null;
    
    /**
     * Input stream tiedostosta lukemista varten.
     */
    ObjectInputStream in = null;
    
    /**
     * Konstruktori.
     * @param file tiedostonimi
     */
    public Highscores(String file) {
        this.highscores = new ArrayList<>();
        this.FILE = file;
    }
    
    /**
     * Metodi lukee high score -listan tiedostosta.
     */
    private void readFile() throws Exception {
        in = new ObjectInputStream(new FileInputStream(FILE));
        highscores = (ArrayList<Highscore>) in.readObject();
        if (in != null) {
            in.close();
        }
    }
    
    /**
     * Metodi kirjoittaa high score -listan tiedostoon.
     */
    private void writeFile() throws Exception {
        out = new ObjectOutputStream(new FileOutputStream(FILE));
        out.writeObject(highscores);
        if (out != null) {
            out.close();
        }
    }
    
    /**
     * Apumetodi high score -listan tyhjentämistä varten.
     */
    private void reset() throws Exception {
        highscores = new ArrayList<>();
        writeFile();
    }

    /**
     * Metodi järjestää high score -listan.
     */
    private void sort() {
        Collections.sort(highscores);
    }
    
    /**
     * Metodi lisää uuden high scoren listaan.
     * @param name pelaajan nimi
     * @param score pelaajan pisteet
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
     * Metodi lukee high score -listan tiedostosta ja palauttaa sen.
     * @return high score -lista
     */
    public ArrayList<Highscore> getHighscores() {
        try {
            readFile();
        } catch (Exception e) {
            System.err.println("Error while loading high scores!" + e.getMessage());
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
