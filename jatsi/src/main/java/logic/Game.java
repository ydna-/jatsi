package logic;

import java.util.ArrayList;

public class Game {
    
    public Die[] dice;
    public ArrayList<Player> players;
    
    public Game() {
        this.dice = new Die[5];
        this.players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.dice[i] = new Die();
        }
    }
    
    public void addPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        this.players.add(player);
    }
    
    public void rollDice() {
        for (int i = 0; i < 5; i++) {
            if (!this.dice[i].isLocked()) {
                this.dice[i].roll();
            }
        }
    }
    
    public void freeDice() {
        for (int i = 0; i < 5; i++) {
            this.dice[i].unlock();
        }
    }
    
    public void putScore(String combination, Player player) {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = dice[i].getValue();
        }
        int score = Calculator.count(numbers, combination);
        player.getScorecard().setScore(score, combination);
    }
    
}
