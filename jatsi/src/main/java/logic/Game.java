package logic;

import java.util.ArrayList;

/**
 * Luokka mallintaa jatsi-noppapeliä.
 */
public class Game {
    
    /**
     * Jatsi-pelin nopat.
     */
    public Die[] dice;
    
    /**
     * Jatsi-pelin pelaajat.
     */
    public ArrayList<Player> players;
    
    /**
     * Pelaaja, joka on parhaillaan vuorossa.
     */
    public int player;
    
    /**
     * Heittovuoro, joka pelaajalla on menossa.
     */
    public int turn;
    
    /**
     * Muuttuja kuvaa, kuinka monta kierrosta peliä on pelattu.
     */
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
    
    /**
     * Metodi kuvaa vuoron siirtymistä seuraavalle pelaajalle.
     */
    public void nextPlayer() {
        this.player += 1;
        if (this.player == this.players.size()) {
            this.player = 0;
            this.counter++;
        }
    }
    
    public void nextTurn() {
        this.turn += 1;
        if (this.turn == 3) {
            this.turn = 0;
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
