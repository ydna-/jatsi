package fileio;

import java.io.Serializable;

/**
 * Luokka mallintaa Yatzy-pelin high scorea.
 */
public class Highscore implements Serializable {
    
    /**
     * Pelaajan nimi.
     */
    private String name;
    
    /**
     * Pelaajan yhteispisteet.
     */
    private int total;
    
    /**
     * Konstruktori.
     * @param name pelaajan nimi
     * @param total pelaajan pisteet
     */
    public Highscore(String name, int total) {
        this.name = name;
        this.total = total;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTotal() {
        return total;
    }
    
}
