package logic;

import java.util.Random;

/**
 * Represents a six-sided die.
 */
public class Die {

    /**
     * Value of the die.
     */
    private int value;
    
    /**
     * Status of the die, true if die can't be rolled.
     */
    private boolean locked;
    
    /**
     * Creates a new die.
     */
    public Die() {
        this.value = 0;
        this.locked = false;
    }
    
    /**
     * Sets the value of the die to a random integer between 1 and 6.
     */
    public void roll() {
        this.value = new Random().nextInt(6)+1;
    }
    
    public int getValue() {
        return value;
    }
    
    /**
     * Locks the die.
     */
    public void lock() {
        this.locked = true;
    }
    
    /**
     * Unlocks the die.
     */
    public void unlock() {
        this.locked = false;
    }
    
    /**
     * Toggles the lock status of the die.
     */
    public void toggle() {
        this.locked = !locked;
    }
    
    /**
     * Returns the lock status of the die.
     * @return true if locked
     */
    public boolean isLocked() {
        return this.locked;
    }
    
}
