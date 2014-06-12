package fileio;

import java.io.Serializable;

/**
 * Luokka mallintaa jatsi-pelin high scorea.
 */
public class Highscore implements Serializable, Comparable<Highscore> {
    
    /**
     * Pelaajan nimi.
     */
    private final String name;
    
    /**
     * Pelaajan yhteispisteet.
     */
    private final int total;
    
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
    
    @Override
    public int compareTo(Highscore that) {
        int thatTotal = that.getTotal();
        return thatTotal - this.total;
    }
    
}
