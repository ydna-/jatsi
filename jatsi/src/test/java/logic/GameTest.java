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
        assertEquals(0, yatzy.player);
        assertEquals(0, yatzy.turn);
        assertEquals(0, yatzy.counter);
        assertEquals(false, yatzy.forced);
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
    public void nextTurnMethodWorks() {
        assertEquals(0, yatzy.turn);
        yatzy.nextTurn();
        assertEquals(1, yatzy.turn);
        yatzy.nextTurn();
        assertEquals(2, yatzy.turn);
        yatzy.nextTurn();
        assertEquals(0, yatzy.turn);
    }
    
    @Test
    public void diceValuesChangeWhenRolled() {
        int turn = yatzy.turn;
        if (turn == 2) {
            turn = -1;
        }
        yatzy.rollDice();
        for (int i = 0; i < 5; i++) {
            assertEquals(true, yatzy.dice[i].getValue() >= 1 && yatzy.dice[i].getValue() <= 6);
        }
        assertEquals(turn+1, yatzy.turn);
    }
    
    @Test
    public void lockedDiceAreNotRolled() {
        yatzy.rollDice();
        int value1 = yatzy.dice[0].getValue();
        int value2 = yatzy.dice[4].getValue();
        int turn = yatzy.turn;
        if (turn == 2) {
            turn = -1;
        }
        yatzy.dice[0].lock();
        yatzy.dice[4].lock();
        yatzy.rollDice();
        assertEquals(value1, yatzy.dice[0].getValue());
        assertEquals(value2, yatzy.dice[4].getValue());
        assertEquals(turn+1, yatzy.turn);
    }
    
    @Test
    public void diceAreUnlockedWhenFreed() {
        yatzy.rollDice();
        for (int i = 0; i < 5; i++) {
            yatzy.dice[i].lock();
        }
        int player = yatzy.player;
        if (player == yatzy.players.size()-1) {
            player = -1;
        }
        yatzy.freeDice();
        for (int i = 0; i < 5; i++) {
            assertEquals(false, yatzy.dice[i].isLocked());
        }
        assertEquals(player+1, yatzy.player);
    }
    
    @Test
    public void scoresArePutToScorecard() {
        yatzy.addPlayer("player");
        yatzy.rollDice();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += yatzy.dice[i].getValue();
        }
        assertEquals(sum, yatzy.putScore("chance"));
        assertEquals(sum, yatzy.players.get(0).getScores().getScore("chance"));
    }
    
    @Test
    public void gameEndsAsExpected() {
        yatzy.addPlayer("zero");
        yatzy.addPlayer("one");
        yatzy.addPlayer("two");
        yatzy.addPlayer("three");
        for (int i = 0; i < 3; i++) {
            yatzy.players.get(i).getScores().setScore(i+1, "ones");
            yatzy.players.get(i).getScores().setScore(2*(i+1), "twos");
            yatzy.players.get(i).getScores().setScore(3*(i+1), "threes");
            yatzy.players.get(i).getScores().setScore(4*(i+1), "fours");
            yatzy.players.get(i).getScores().setScore(5*(i+1), "fives");
            yatzy.players.get(i).getScores().setScore(6*(i+1), "sixes");
            yatzy.players.get(i).getScores().setScore(2*(i+3), "pair");
            yatzy.players.get(i).getScores().setScore(0, "two pairs");
            yatzy.players.get(i).getScores().setScore(3*(i+3), "three of a kind");
            yatzy.players.get(i).getScores().setScore(0, "four of a kind");
            yatzy.players.get(i).getScores().setScore(0, "small straight");
            yatzy.players.get(i).getScores().setScore(0, "large straight");
            yatzy.players.get(i).getScores().setScore(0, "full house");
            yatzy.players.get(i).getScores().setScore(10*i, "chance");
            yatzy.players.get(i).getScores().setScore(50, "yatzy");
        }
        yatzy.players.get(3).getScores().setScore(3, "ones");
        yatzy.players.get(3).getScores().setScore(6, "twos");
        yatzy.players.get(3).getScores().setScore(9, "threes");
        yatzy.players.get(3).getScores().setScore(12, "fours");
        yatzy.players.get(3).getScores().setScore(15, "fives");
        yatzy.players.get(3).getScores().setScore(18, "sixes");
        yatzy.players.get(3).getScores().setScore(10, "pair");
        yatzy.players.get(3).getScores().setScore(0, "two pairs");
        yatzy.players.get(3).getScores().setScore(15, "three of a kind");
        yatzy.players.get(3).getScores().setScore(0, "four of a kind");
        yatzy.players.get(3).getScores().setScore(0, "small straight");
        yatzy.players.get(3).getScores().setScore(0, "large straight");
        yatzy.players.get(3).getScores().setScore(0, "full house");
        yatzy.players.get(3).getScores().setScore(20, "chance");
        yatzy.players.get(3).getScores().setScore(50, "yatzy");
        int winner = yatzy.endGame();
        assertEquals(yatzy.players.size()-2, winner);
        for (int i = 0; i < 3; i++) {
            assertEquals(21*(i+1), yatzy.players.get(i).getScores().getScore("upper total"));
        }
    }
    
}
