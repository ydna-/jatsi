package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Player one;
    
    public PlayerTest() {
        this.one = new Player("player");
    }
    
    @Test
    public void correctPlayerName() {
        assertEquals("player", one.getName());
    }
    
    @Test
    public void returnScoreFromCard() {
        assertEquals(-1, one.getScores().scores[0]);
    }
    
}
