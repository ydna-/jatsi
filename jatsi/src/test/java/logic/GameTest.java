package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    @Test
    public void gameBeginsAsExpected() {
        Game yatzy = new Game();
        assertEquals(5, yatzy.dice.length);
        assertEquals(0, yatzy.players.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(0, yatzy.dice[i].getValue());
            assertEquals(false, yatzy.dice[i].isLocked());
        }
    }
    
    @Test
    public void playersAreAddedToList() {
        Game yatzy = new Game();
        yatzy.addPlayer("first");
        yatzy.addPlayer("second");
        yatzy.addPlayer("third");
        assertEquals(3, yatzy.players.size());
        assertEquals("first", yatzy.players.get(0).getName());
        assertEquals("second", yatzy.players.get(1).getName());
        assertEquals("third", yatzy.players.get(2).getName());
    }
    
    @Test
    public void diceValuesChangeWhenRolled() {
        Game yatzy = new Game();
        yatzy.rollDice();
        for (int i = 0; i < 5; i++) {
            assertEquals(true, yatzy.dice[i].getValue() >= 1 && yatzy.dice[i].getValue() <= 6);
        }
    }
    
    @Test
    public void lockedDiceAreNotRolled() {
        Game yatzy = new Game();
        yatzy.rollDice();
        int value1 = yatzy.dice[0].getValue();
        int value2 = yatzy.dice[4].getValue();
        yatzy.dice[0].lock();
        yatzy.dice[4].lock();
        yatzy.rollDice();
        assertEquals(value1, yatzy.dice[0].getValue());
        assertEquals(value2, yatzy.dice[4].getValue());
    }
    
    @Test
    public void diceAreUnlockedWhenFreed() {
        Game yatzy = new Game();
        yatzy.rollDice();
        for (int i = 0; i < 5; i++) {
            yatzy.dice[i].lock();
        }
        yatzy.freeDice();
        for (int i = 0; i < 5; i++) {
            assertEquals(false, yatzy.dice[i].isLocked());
        }
    }
    
    @Test
    public void scoresArePutToScorecard() {
        Game yatzy = new Game();
        yatzy.addPlayer("player");
        yatzy.rollDice();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += yatzy.dice[i].getValue();
        }
        yatzy.putScore("chance", yatzy.players.get(0));
        assertEquals(sum, yatzy.players.get(0).getScores().getScore("chance"));
    }
    
}
