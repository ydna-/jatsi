package fileio;

import org.junit.Test;
import static org.junit.Assert.*;

public class HighscoreComparatorTest {
    
    HighscoreComparator comparator;
    
    public HighscoreComparatorTest() {
        this.comparator = new HighscoreComparator();
    }

    @Test
    public void firstScoreLarger() {
        Highscore first = new Highscore("first", 200);
        Highscore second = new Highscore("second", 100);
        assertEquals(-1, comparator.compare(first, second));
    }
    
    @Test
    public void firstScoreSmaller() {
        Highscore first = new Highscore("first", 100);
        Highscore second = new Highscore("second", 200);
        assertEquals(1, comparator.compare(first, second));
    }
    
    @Test
    public void firstScoreEquals() {
        Highscore first = new Highscore("first", 150);
        Highscore second = new Highscore("second", 150);
        assertEquals(0, comparator.compare(first, second));
    }
    
}
