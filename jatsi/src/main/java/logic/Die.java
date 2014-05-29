package logic;

import java.util.Random;

public class Die {

    private int value;
    private boolean locked;
    
    public Die() {
        this.value = 0;
        this.locked = false;
    }
    
    public void roll() {
        this.value = new Random().nextInt(6)+1;
    }
    
    public int getValue() {
        return value;
    }
    
    public void lock() {
        this.locked = true;
    }
    
    public void unlock() {
        this.locked = false;
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
}
