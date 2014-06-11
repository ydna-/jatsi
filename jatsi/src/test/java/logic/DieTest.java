package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class DieTest {
    
    Die dice;
    
    public DieTest() {
        this.dice = new Die();
    }
    
    @Test
    public void dieValueBetweenOneAndSix() {
        for (int i = 0; i < 30; i++) {
            dice.roll();
            assertEquals(true, dice.getValue() >= 1 && dice.getValue() <= 6);
        }
    }
    
    @Test
    public void dieLocked() {
        dice.roll();
        dice.lock();
        assertEquals(true, dice.isLocked());
    }
    
    @Test
    public void dieUnlocked() {
        dice.lock();
        dice.unlock();
        assertEquals(false, dice.isLocked());
    }
    
    @Test
    public void lockToggled() {
        dice.lock();
        dice.toggle();
        assertEquals(false, dice.isLocked());
        dice.toggle();
        assertEquals(true, dice.isLocked());
    }
    
}
