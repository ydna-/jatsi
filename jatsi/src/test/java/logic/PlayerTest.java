package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    @Test
    public void correctPlayerName() {
        Player one = new Player();
        one.setName("playername");
        assertEquals("playername", one.getName());
    }
    
    @Test
    public void returnScoreFromCard() {
        Player two = new Player();
        assertEquals(-1, two.getScorecard().scores[0]);
    }
    
}
