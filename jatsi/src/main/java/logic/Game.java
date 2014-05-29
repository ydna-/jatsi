package logic;

public class Game {
    
    public Die[] dice;
    public Player singlePlayer;
    
    public Game() {
        this.dice = new Die[5];
        this.singlePlayer = new Player();
        for (int i = 0; i < 5; i++) {
            this.dice[i] = new Die();
        }
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
    
    public void putScore(String combination) {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = dice[i].getValue();
        }
        int score = Calculator.count(numbers, combination);
        singlePlayer.getScorecard().setScore(score, combination);
    }
    
}
