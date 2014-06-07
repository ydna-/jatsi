package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScoresTest {
    
    @Test
    public void scoresAreMinusOne() {
        Scores card = new Scores();
        assertEquals(-1, card.getScore("ones"));
        assertEquals(-1, card.getScore("twos"));
        assertEquals(-1, card.getScore("threes"));
        assertEquals(-1, card.getScore("fours"));
        assertEquals(-1, card.getScore("fives"));
        assertEquals(-1, card.getScore("sixes"));
        assertEquals(-1, card.getScore("pair"));
        assertEquals(-1, card.getScore("two pairs"));
        assertEquals(-1, card.getScore("three of a kind"));
        assertEquals(-1, card.getScore("four of a kind"));
        assertEquals(-1, card.getScore("small straight"));
        assertEquals(-1, card.getScore("large straight"));
        assertEquals(-1, card.getScore("full house"));
        assertEquals(-1, card.getScore("chance"));
        assertEquals(-1, card.getScore("yatzy"));
        assertEquals(-1, card.getScore("upper total"));
        assertEquals(-1, card.getScore("bonus"));
        assertEquals(-1, card.getScore("total"));
    }
    
    @Test
    public void invalidInputReturnsZero() {
        Scores card = new Scores();
        assertEquals(0, card.getScore("input"));
    }
    
    @Test
    public void scoresSetCorrectly1() {
        Scores card = new Scores();
        card.setScore(5, "ones");
        card.setScore(10, "twos");
        card.setScore(15, "threes");
        card.setScore(20, "fours");
        card.setScore(25, "fives");
        card.setScore(30, "sixes");
        card.setScore(12, "pair");
        card.setScore(22, "two pairs");
        card.setScore(18, "three of a kind");
        card.setScore(24, "four of a kind");
        card.setScore(15, "small straight");
        card.setScore(20, "large straight");
        card.setScore(28, "full house");
        card.setScore(30, "chance");
        card.setScore(50, "yatzy");
        card.setUpperTotal();
        card.setTotal();
        assertEquals(5, card.getScore("ones"));
        assertEquals(10, card.getScore("twos"));
        assertEquals(15, card.getScore("threes"));
        assertEquals(20, card.getScore("fours"));
        assertEquals(25, card.getScore("fives"));
        assertEquals(30, card.getScore("sixes"));
        assertEquals(12, card.getScore("pair"));
        assertEquals(22, card.getScore("two pairs"));
        assertEquals(18, card.getScore("three of a kind"));
        assertEquals(24, card.getScore("four of a kind"));
        assertEquals(15, card.getScore("small straight"));
        assertEquals(20, card.getScore("large straight"));
        assertEquals(28, card.getScore("full house"));
        assertEquals(30, card.getScore("chance"));
        assertEquals(50, card.getScore("yatzy"));
        assertEquals(105, card.getScore("upper total"));
        assertEquals(50, card.getScore("bonus"));
        assertEquals(374, card.getScore("total"));
    }
    
    @Test
    public void scoresSetCorrectly2() {
        Scores card = new Scores();
        card.setScore(1, "ones");
        card.setScore(2, "twos");
        card.setScore(3, "threes");
        card.setScore(4, "fours");
        card.setScore(5, "fives");
        card.setScore(6, "sixes");
        card.setScore(2, "pair");
        card.setScore(6, "two pairs");
        card.setScore(3, "three of a kind");
        card.setScore(4, "four of a kind");
        card.setScore(0, "small straight");
        card.setScore(0, "large straight");
        card.setScore(7, "full house");
        card.setScore(5, "chance");
        card.setScore(0, "yatzy");
        card.setUpperTotal();
        card.setTotal();
        assertEquals(1, card.getScore("ones"));
        assertEquals(2, card.getScore("twos"));
        assertEquals(3, card.getScore("threes"));
        assertEquals(4, card.getScore("fours"));
        assertEquals(5, card.getScore("fives"));
        assertEquals(6, card.getScore("sixes"));
        assertEquals(2, card.getScore("pair"));
        assertEquals(6, card.getScore("two pairs"));
        assertEquals(3, card.getScore("three of a kind"));
        assertEquals(4, card.getScore("four of a kind"));
        assertEquals(0, card.getScore("small straight"));
        assertEquals(0, card.getScore("large straight"));
        assertEquals(7, card.getScore("full house"));
        assertEquals(5, card.getScore("chance"));
        assertEquals(0, card.getScore("yatzy"));
        assertEquals(21, card.getScore("upper total"));
        assertEquals(0, card.getScore("bonus"));
        assertEquals(48, card.getScore("total"));
    }
    
}
