package logic;

import java.util.Random;

/**
 * Luokka mallintaa kuusisivuista noppaa jatsi-noppapelissä.
 */
public class Die {

    private int value;
    private boolean locked;
    
    /**
     * Konstruktori.
     */
    public Die() {
        this.value = 0;
        this.locked = false;
    }
    
    /**
     * Metodi asettaa nopan arvoksi satunnaisen kokonaisluvun väliltä 1-6.
     */
    public void roll() {
        this.value = new Random().nextInt(6)+1;
    }
    
    /**
     * Metodi palauttaa nopan arvon.
     * @return nopan arvo
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Metodi asettaa nopan lukituksi.
     */
    public void lock() {
        this.locked = true;
    }
    
    /**
     * Metodi vapauttaa nopan, siis poistaa lukituksen.
     */
    public void unlock() {
        this.locked = false;
    }
    
    /**
     * Metodi vaihtaa nopan lukituksen totuusarvon.
     */
    public void toggle() {
        this.locked = !locked;
    }
    
    /**
     * Metodi kertoo, onko noppa lukittu vai ei.
     * @return lukittu?
     */
    public boolean isLocked() {
        return this.locked;
    }
    
}
