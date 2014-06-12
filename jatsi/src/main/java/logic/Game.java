package logic;

import java.util.ArrayList;

/**
 * Luokka mallintaa jatsi-noppapeliä.
 */
public class Game {
    
    public Die[] dice;
    public ArrayList<Player> players;
    public int player;
    public int turn;
    public int counter;
    
    /**
     * Konstruktori.
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
    }
    
    /**
     * Metodi lisää peliin pelaajan.
     * @param name pelaajan nimi
     */
    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }
    
    public void nextPlayer() {
        if (this.player == players.size() - 1) {
            this.player = 0;
            counter++;
        } else {
            this.player += 1;
        }
    }
    
    /**
     * Metodi heittää niitä noppia, joita ei ole asetettu lukituksi.
     */
    public void rollDice() {
        for (int i = 0; i < 5; i++) {
            if (!this.dice[i].isLocked()) {
                this.dice[i].roll();
            }
        }
    }
    
    /**
     * Metodi vapauttaa kaikki nopat, siis poistaa lukituksen.
     */
    public void freeDice() {
        for (int i = 0; i < 5; i++) {
            this.dice[i].unlock();
        }
    }
    
    /**
     * Metodi lisää pelaajan valitsemasta noppa-yhdistelmästä saadut pisteet pelaajalle.
     * @param combination noppa-yhdistelmä
     * @param player pelaaja
     * @return pisteet
     */
    public int putScore(String combination, Player player) {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = dice[i].getValue();
        }
        int score = Calculator.count(numbers, combination);
        player.getScores().setScore(score, combination);
        return score;
    }
    
}
