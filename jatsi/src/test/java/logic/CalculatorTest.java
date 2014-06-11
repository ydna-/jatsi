package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    @Test
    public void correctOnes1() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(2, Calculator.count(dice, "ones"));
    }
    
    @Test
    public void correctOnes2() {
        int[] dice = {3, 2, 4, 2, 5};
        assertEquals(0, Calculator.count(dice, "ones"));
    }
    
    @Test
    public void correctTwos1() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice, "twos"));
    }
    
    @Test
    public void correctTwos2() {
        int[] dice = {2, 2, 4, 2, 5};
        assertEquals(6, Calculator.count(dice, "twos"));
    }
    
    @Test
    public void correctThrees1() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(3, Calculator.count(dice, "threes"));
    }
    
    @Test
    public void correctThrees2() {
        int[] dice = {3, 2, 3, 3, 3};
        assertEquals(12, Calculator.count(dice, "threes"));
    }
    
    @Test
    public void correctFours1() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(4, Calculator.count(dice, "fours"));
    }
    
    @Test
    public void correctFours2() {
        int[] dice = {4, 1, 4, 1, 5};
        assertEquals(8, Calculator.count(dice, "fours"));
    }
    
    @Test
    public void correctFives1() {
        int[] dice = {5, 1, 4, 1, 5};
        assertEquals(10, Calculator.count(dice, "fives"));
    }
    
    @Test
    public void correctFives2() {
        int[] dice = {3, 5, 5, 5, 5};
        assertEquals(20, Calculator.count(dice, "fives"));
    }
    
    @Test
    public void correctSixes1() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice, "sixes"));
    }
    
    @Test
    public void correctSixes2() {
        int[] dice = {6, 6, 6, 6, 5};
        assertEquals(24, Calculator.count(dice, "sixes"));
    }
    
    @Test
    public void correctPair1() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(2, Calculator.count(dice, "pair"));
    }
    
    @Test
    public void correctPair2() {
        int[] dice = {5, 1, 4, 1, 5};
        assertEquals(10, Calculator.count(dice, "pair"));
    }
    
    @Test
    public void correctPair3() {
        int[] dice = {3, 2, 4, 1, 5};
        assertEquals(0, Calculator.count(dice, "pair"));
    }
    
    @Test
    public void correctTwoPairs1() {
        int[] dice = {5, 2, 4, 2, 5};
        assertEquals(14, Calculator.count(dice, "two pairs"));
    }
    
    @Test
    public void correctTwoPairs2() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice, "two pairs"));
    }
    
    @Test
    public void correctTwoPairs3() {
        int[] dice = {5, 6, 6, 6, 5};
        assertEquals(22, Calculator.count(dice, "two pairs"));
    }
    
    @Test
    public void correctTwoPairs4() {
        int[] dice = {2, 2, 3, 3, 5};
        assertEquals(10, Calculator.count(dice, "two pairs"));
    }
    
    @Test
    public void correctTwoPairs5() {
        int[] dice = {1, 5, 6, 5, 6};
        assertEquals(22, Calculator.count(dice, "two pairs"));
    }
    
    @Test
    public void correctTwoPairs6() {
        int[] dice = {5, 5, 5, 5, 1};
        assertEquals(0, Calculator.count(dice, "two pairs"));
    }
    
    @Test
    public void correctThreeOfAKind1() {
        int[] dice = {5, 6, 6, 6, 5};
        assertEquals(18, Calculator.count(dice, "three of a kind"));
    }
    
    @Test
    public void correctThreeOfAKind2() {
        int[] dice = {5, 6, 5, 6, 5};
        assertEquals(15, Calculator.count(dice, "three of a kind"));
    }
    
    @Test
    public void correctThreeOfAKind3() {
        int[] dice = {5, 6, 6, 4, 5};
        assertEquals(0, Calculator.count(dice, "three of a kind"));
    }
    
    @Test
    public void correctFourOfAKind1() {
        int[] dice = {5, 6, 6, 6, 5};
        assertEquals(0, Calculator.count(dice, "four of a kind"));
    }
    
    @Test
    public void correctFourOfAKind2() {
        int[] dice = {1, 1, 1, 6, 1};
        assertEquals(4, Calculator.count(dice, "four of a kind"));
    }
    
    @Test
    public void correctFourOfAKind3() {
        int[] dice = {5, 5, 2, 5, 5};
        assertEquals(20, Calculator.count(dice, "four of a kind"));
    }
    
    @Test
    public void correctSmallStraight1() {
        int[] dice = {5, 3, 2, 1, 4};
        assertEquals(15, Calculator.count(dice, "small straight"));
    }
    
    @Test
    public void correctSmallStraight2() {
        int[] dice = {5, 3, 2, 6, 4};
        assertEquals(0, Calculator.count(dice, "small straight"));
    }
    
    @Test
    public void correctLargeStraight1() {
        int[] dice = {5, 2, 3, 6, 4};
        assertEquals(20, Calculator.count(dice, "large straight"));
    }
    
    @Test
    public void correctLargeStraight2() {
        int[] dice = {1, 1, 2, 5, 4};
        assertEquals(0, Calculator.count(dice, "large straight"));
    }
    
    @Test
    public void correctFullHouse1() {
        int[] dice = {1, 2, 1, 2, 1};
        assertEquals(7, Calculator.count(dice, "full house"));
    }
    
    @Test
    public void correctFullHouse2() {
        int[] dice = {6, 6, 4, 4, 4};
        assertEquals(24, Calculator.count(dice, "full house"));
    }
    
    @Test
    public void correctFullHouse3() {
        int[] dice = {3, 1, 4, 1, 4};
        assertEquals(0, Calculator.count(dice, "full house"));
    }
    
    @Test
    public void correctFullHouse4() {
        int[] dice = {6, 6, 6, 3, 3};
        assertEquals(24, Calculator.count(dice, "full house"));
    }
    
    @Test
    public void correctFullHouse5() {
        int[] dice = {5, 5, 5, 5, 5};
        assertEquals(0, Calculator.count(dice, "full house"));
    }
    
    @Test
    public void correctChance() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(14, Calculator.count(dice, "chance"));
    }
    
    @Test
    public void correctYatzy1() {
        int[] dice = {5, 5, 5, 5, 5};
        assertEquals(50, Calculator.count(dice, "yatzy"));
    }
    
    @Test
    public void correctYatzy2() {
        int[] dice = {3, 1, 4, 1, 5};
        assertEquals(0, Calculator.count(dice, "yatzy"));
    }
    
    @Test
    public void invalidInput() {
        int[] dice = {1, 2, 3, 4, 5};
        assertEquals(-1, Calculator.count(dice, "input"));
    }
    
}
