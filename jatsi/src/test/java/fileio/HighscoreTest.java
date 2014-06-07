package fileio;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighscoreTest {

    @Test
    public void correctName() {
        Highscore score = new Highscore("name", 187);
        assertEquals("name", score.getName());
    }
    
    @Test
    public void correctTotal() {
        Highscore score = new Highscore("player", 666);
        assertEquals(666, score.getTotal());
    }
    
}
