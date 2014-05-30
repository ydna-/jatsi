package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class DieTest {
    
    @Test
    public void dieValueBetweenOneAndSix() {
        Die dice = new Die();
        dice.roll();
        assertEquals(true, dice.getValue() <= 6 && dice.getValue() > 0);
    }
    
    @Test
    public void dieLocked() {
        Die dice = new Die();
        dice.roll();
        dice.lock();
        assertEquals(true, dice.isLocked());
    }
    
    @Test
    public void dieUnlocked() {
        Die dice = new Die();
        dice.lock();
        dice.unlock();
        assertEquals(false, dice.isLocked());
    }
    
}
