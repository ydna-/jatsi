package logic;

/**
 * Represents a player in the game.
 */
public class Player {
    
    /**
     * Name of the player.
     */
    private final String name;
    
    /**
     * Score table of the player.
     */
    private final Scores scores;
    
    /**
     * Creates a new player with the given name.
     * @param name Player's name.
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
