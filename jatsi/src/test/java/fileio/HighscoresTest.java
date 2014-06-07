package fileio;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighscoresTest {
    
    Highscores scores;
    
    public HighscoresTest() {
        this.scores = new Highscores();
        scores.reset();
    }

    @Test
    public void listEmpty() {
        assertEquals(0, scores.getHighscores().size());
    }
    
    @Test
    public void highscoresAdded() {
        scores.addScore("first", 300);
        scores.addScore("second", 200);
        assertEquals(2, scores.getHighscores().size());
        assertEquals(300, scores.getHighscores().get(0).getTotal());
        assertEquals(200, scores.getHighscores().get(1).getTotal());
        assertEquals("first", scores.getHighscores().get(0).getName());
        assertEquals("second", scores.getHighscores().get(1).getName());
        assertEquals('1', scores.toString().charAt(0));
        assertEquals(true, scores.toString().contains("first"));
    }
    
    @Test
    public void highscoresReset() {
        scores.reset();
        assertEquals(0, scores.getHighscores().size());
        assertEquals(0, scores.toString().length());
    }
    
}
