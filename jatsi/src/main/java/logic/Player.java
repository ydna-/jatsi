package logic;

/**
 * Luokka mallintaa jatsi-noppapelin pelaajaa.
 */
public class Player {
    
    /**
     * Pelaajan nimi.
     */
    private String name;
    
    /**
     * Pelaajan pisteet.
     */
    private Scores scores;
    
    /**
     * Konstruktori.
     * @param name pelaajan nimi
     */
    public Player(String name) {
        this.name = name;
        this.scores = new Scores();
    }
    
    public String getName() {
        return this.name;
    }
    
    public Scores getScores() {
        return this.scores;
    }
    
}
