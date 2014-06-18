package logic;

import java.util.ArrayList;

/**
 * Represents the dice game as a whole and contains methods for game flow.
 */
public class Game {
    
    /**
     * The dice of the game.
     */
    public Die[] dice;
    
    /**
     * The players of the game.
     */
    public ArrayList<Player> players;
    
    /**
     * Index of the player currently playing.
     */
    public int player;
    
    /**
     * Turn number of the player currently playing.
     */
    public int turn;
    
    /**
     * Number of rounds played.
     */
    public int counter;
    
    /**
     * Is true if the game mode is forced.
     */
    public boolean forced;
    
    /**
     * Creates a new game.
     */
    public Game() {
        this.dice = new Die[5];
        this.players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.dice[i] = new Die();
        }
        this.player = 0;
        this.turn = 0;
        this.counter = 0;
        this.forced = false;
    }
    
    /**
     * Adds a new player to the game.
     * @param name Player's name.
     */
    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }
    
    /**
     * Increases the turn counter.
     */
    public void nextTurn() {
        this.turn += 1;
        if (this.turn == 3) {
            this.turn = 0;
        }
    }
    
    /**
     * Increases the player counter.
     */
    public void nextPlayer() {
        this.player += 1;
        if (this.player == this.players.size()) {
            this.player = 0;
            this.counter++;
        }
    }
    
    /**
     * Rolls all dice which are unlocked.
     */
    public void rollDice() {
        for (int i = 0; i < 5; i++) {
            if (!this.dice[i].isLocked()) {
                this.dice[i].roll();
            }
        }
        nextTurn();
    }
    
    /**
     * Unlocks all dice, so they can be rolled.
     */
    public void freeDice() {
        for (int i = 0; i < 5; i++) {
            this.dice[i].unlock();
        }
        nextPlayer();
    }
    
    /**
     * Puts the score from a given dice combination to the score card of a player.
     * @param combination Dice combination.
     * @return Score.
     */
    public int putScore(String combination) {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = dice[i].getValue();
        }
        int score = Calculator.count(numbers, combination);
        this.players.get(this.player).getScores().setScore(score, combination);
        return score;
    }
    
    /**
     * Ends the game by setting the upper totals and totals in the score table of each player.
     * @return Index number of the winner.
     */
    public int endGame() {
        int winner = 0;
        int score = 0;
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).getScores().setUpperTotal();
            this.players.get(i).getScores().setTotal();
            if (score < this.players.get(i).getScores().getScore("total")) {
                winner = i;
                score = this.players.get(i).getScores().getScore("total");
            }
        }
        return winner;
    }
    
}
