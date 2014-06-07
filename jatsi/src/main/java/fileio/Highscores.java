package fileio;

import java.util.*;
import java.io.*;

/**
 * Luokka tarjoaa metodeja, joilla päivitetään Yatzy-noppapelin high score -listaa.
 */
public class Highscores {
    
    /**
     * High score -lista.
     */
    private ArrayList<Highscore> highscores;
    
    /**
     * Tiedosto, jossa high score -listaa säilytetään.
     */
    private final String FILE = "highscores.dat";
    
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
     */
    public Highscores() {
        this.highscores = new ArrayList<>();
    }
    
    /**
     * Metodi lukee high score -listan tiedostosta.
     */
    private void readFile() {
        try {
            in = new ObjectInputStream(new FileInputStream(FILE));
            highscores = (ArrayList<Highscore>) in.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("CNF Error while loading: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("FNF Error while loading: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error while loading: " + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error while loading: " + e.getMessage());
            }
        }
    }
    
    /**
     * Metodi kirjoittaa high score -listan tiedostoon.
     */
    private void writeFile() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(FILE));
            out.writeObject(highscores);
        } catch (FileNotFoundException e) {
            System.out.println("FNF Error while writing: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error while writing: " + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                System.out.println("IO Error while writing: " + e.getMessage());
            }
        }
    }
    
    /**
     * Apumetodi high score -listan tyhjentämistä varten.
     */
    public void reset() {
        highscores = new ArrayList<>();
        writeFile();
    }
    
    /**
     * Metodi järjestää high score -listan.
     */
    private void sort() {
        HighscoreComparator comparator = new HighscoreComparator();
        Collections.sort(highscores, comparator);
    }
    
    /**
     * Metodi lisää uuden high scoren listaan.
     * @param name pelaajan nimi
     * @param score pelaajan pisteet
     */
    public void addScore(String name, int score) {
        readFile();
        highscores.add(new Highscore(name, score));
        writeFile();
    }
    
    /**
     * Metodi lukee high score -listan tiedostosta ja palauttaa sen.
     * @return high score -lista
     */
    public ArrayList<Highscore> getHighscores() {
        readFile();
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
            temp += (i+1) + ".\t" + highscores.get(i).getName() + "\t" + highscores.get(i).getTotal() + "\n";
        }
        return temp;
    }
    
}
