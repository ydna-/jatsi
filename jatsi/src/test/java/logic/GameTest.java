package logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    Game yatzy;
    
    public GameTest() {
        this.yatzy = new Game();
    }
    
    @Test
    public void gameBeginsAsExpected() {
        assertEquals(5, yatzy.dice.length);
        assertEquals(0, yatzy.players.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(0, yatzy.dice[i].getValue());
            assertEquals(false, yatzy.dice[i].isLocked());
        }
    }
    
    @Test
    public void playersAreAddedToList() {
        yatzy.addPlayer("first");
        yatzy.addPlayer("second");
        yatzy.addPlayer("third");
        assertEquals(3, yatzy.players.size());
        assertEquals("first", yatzy.players.get(0).getName());
        assertEquals("second", yatzy.players.get(1).getName());
        assertEquals("third", yatzy.players.get(2).getName());
    }
    
    @Test
    public void nextPlayerMethodWorks() {
        yatzy.addPlayer("first");
        yatzy.addPlayer("second");
        yatzy.addPlayer("third");
        assertEquals(0, yatzy.counter);
        for (int i = 0; i < yatzy.players.size(); i++) {
            assertEquals(i, yatzy.player);
            yatzy.nextPlayer();
        }
        assertEquals(0, yatzy.player);
        assertEquals(1, yatzy.counter);
    }
    
    @Test
    public void diceValuesChangeWhenRolled() {
        yatzy.rollDice();
        for (int i = 0; i < 5; i++) {
            assertEquals(true, yatzy.dice[i].getValue() >= 1 && yatzy.dice[i].getValue() <= 6);
        }
    }
    
    @Test
    public void lockedDiceAreNotRolled() {
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
        yatzy.addPlayer("player");
        yatzy.rollDice();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += yatzy.dice[i].getValue();
        }
        assertEquals(sum, yatzy.putScore("chance", yatzy.players.get(0)));
        assertEquals(sum, yatzy.players.get(0).getScores().getScore("chance"));
    }
    
}
