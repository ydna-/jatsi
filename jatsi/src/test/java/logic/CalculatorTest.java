package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    Calculator calc;
    
    public CalculatorTest() {
        this.calc = new Calculator();
    }
    
    @Test
    public void correctOnes() {
        int[] dice1 = {3, 1, 4, 1, 5};
        assertEquals(2, Calculator.count(dice1, "ones"));
        int[] dice2 = {3, 2, 4, 2, 5};
        assertEquals(0, Calculator.count(dice2, "ones"));
    }
    
    
    @Test
    public void correctTwos() {
        int[] dice1 = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice1, "twos"));
        int[] dice2 = {2, 2, 4, 2, 5};
        assertEquals(6, Calculator.count(dice2, "twos"));
    }
    
    @Test
    public void correctThrees() {
        int[] dice1 = {3, 1, 4, 1, 5};
        assertEquals(3, Calculator.count(dice1, "threes"));
        int[] dice2 = {3, 2, 3, 3, 3};
        assertEquals(12, Calculator.count(dice2, "threes"));
    }

    @Test
    public void correctFours() {
        int[] dice1 = {3, 1, 4, 1, 5};
        assertEquals(4, Calculator.count(dice1, "fours"));
        int[] dice2 = {4, 1, 4, 1, 5};
        assertEquals(8, Calculator.count(dice2, "fours"));
    }
    
    @Test
    public void correctFives() {
        int[] dice1 = {5, 1, 4, 1, 5};
        assertEquals(10, Calculator.count(dice1, "fives"));
        int[] dice2 = {3, 5, 5, 5, 5};
        assertEquals(20, Calculator.count(dice2, "fives"));
    }

    @Test
    public void correctSixes() {
        int[] dice1 = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice1, "sixes"));
        int[] dice2 = {6, 6, 6, 6, 5};
        assertEquals(24, Calculator.count(dice2, "sixes"));
    }

    @Test
    public void correctPair() {
        int[] dice1 = {3, 1, 4, 1, 5};
        assertEquals(2, Calculator.count(dice1, "pair"));
        int[] dice2 = {5, 1, 4, 1, 5};
        assertEquals(10, Calculator.count(dice2, "pair"));
        int[] dice3 = {3, 2, 4, 1, 5};
        assertEquals(0, Calculator.count(dice3, "pair"));
    }
    
    @Test
    public void correctTwoPairs() {
        int[] dice1 = {5, 2, 4, 2, 5};
        assertEquals(14, Calculator.count(dice1, "two pairs"));
        int[] dice2 = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice2, "two pairs"));
        int[] dice3 = {5, 6, 6, 6, 5};
        assertEquals(22, Calculator.count(dice3, "two pairs"));
        int[] dice4 = {2, 2, 3, 3, 5};
        assertEquals(10, Calculator.count(dice4, "two pairs"));
        int[] dice5 = {1, 5, 6, 5, 6};
        assertEquals(22, Calculator.count(dice5, "two pairs"));
        int[] dice6 = {5, 5, 5, 5, 1};
        assertEquals(0, Calculator.count(dice6, "two pairs"));
    }

    @Test
    public void correctThreeOfAKind() {
        int[] dice1 = {5, 6, 6, 6, 5};
        assertEquals(18, Calculator.count(dice1, "three of a kind"));
        int[] dice2 = {5, 6, 5, 6, 5};
        assertEquals(15, Calculator.count(dice2, "three of a kind"));
        int[] dice3 = {5, 6, 6, 4, 5};
        assertEquals(0, Calculator.count(dice3, "three of a kind"));
    }

    @Test
    public void correctFourOfAKind() {
        int[] dice1 = {5, 6, 6, 6, 5};
        assertEquals(0, Calculator.count(dice1, "four of a kind"));
        int[] dice2 = {1, 1, 1, 6, 1};
        assertEquals(4, Calculator.count(dice2, "four of a kind"));
        int[] dice3 = {5, 5, 2, 5, 5};
        assertEquals(20, Calculator.count(dice3, "four of a kind"));
    }

    @Test
    public void correctSmallStraight() {
        int[] dice1 = {5, 3, 2, 1, 4};
        assertEquals(15, Calculator.count(dice1, "small straight"));
        int[] dice2 = {5, 3, 2, 6, 4};
        assertEquals(0, Calculator.count(dice2, "small straight"));
    }
    
    @Test
    public void correctLargeStraight() {
        int[] dice1 = {5, 2, 3, 6, 4};
        assertEquals(20, Calculator.count(dice1, "large straight"));
        int[] dice2 = {1, 1, 2, 5, 4};
        assertEquals(0, Calculator.count(dice2, "large straight"));
    }
    
    @Test
    public void correctFullHouse() {
        int[] dice1 = {1, 2, 1, 2, 1};
        assertEquals(7, Calculator.count(dice1, "full house"));
        int[] dice2 = {6, 6, 4, 4, 4};
        assertEquals(24, Calculator.count(dice2, "full house"));
        int[] dice3 = {3, 1, 4, 1, 4};
        assertEquals(0, Calculator.count(dice3, "full house"));
        int[] dice4 = {6, 6, 6, 3, 3};
        assertEquals(24, Calculator.count(dice4, "full house"));
        int[] dice5 = {5, 5, 5, 5, 5};
        assertEquals(0, Calculator.count(dice5, "full house"));
    }

    @Test
    public void correctChance() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(14, Calculator.count(dice, "chance"));
    }
    
    @Test
    public void correctYatzy() {
        int[] dice1 = {5, 5, 5, 5, 5};
        assertEquals(50, Calculator.count(dice1, "yatzy"));
        int[] dice2 = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice2, "yatzy"));
    }
    
    @Test
    public void invalidInput() {
        int[] dice = {1, 2, 3, 4, 5};
        assertEquals(-1, Calculator.count(dice, "input"));
    }
    
}
