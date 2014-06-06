package logic;

/**
 * Luokka mallintaa Yatzy-noppapelin pelaajaa.
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
     */
    public Player() {
        this.name = "";
        this.scores = new Scores();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Scores getScores() {
        return this.scores;
    }
    
}
