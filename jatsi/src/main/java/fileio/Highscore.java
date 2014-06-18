package fileio;

import java.io.Serializable;

/**
 * Represents a high score of the game.
 */
public class Highscore implements Serializable, Comparable<Highscore> {
    
    /**
     * Name of the player.
     */
    private final String name;
    
    /**
     * Total points scored in the game.
     */
    private final int total;
    
    /**
     * Creates a new high score with the given name and points.
     * @param name Player's name.
     * @param total Total points.
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
    public int compareTo(Highscore score) {
        return score.getTotal() - this.total;
    }
    
}
