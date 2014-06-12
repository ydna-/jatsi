package logic;

import java.util.Arrays;

/**
 * Luokka tarjoaa metodin pelaajan pisteiden laskemiseen eri noppayhdistelmillä.
 */
public class Calculator {
        
    /**
     * Metodi laskee pelaajan saamat pisteet tietyllä noppayhdistelmällä.
     * @param dice pelaajan nopat
     * @param combination noppayhdistelmä
     * @return pelaajan pisteet
     */
    public static int count(int[] dice, String combination) {
        Arrays.sort(dice);
        combination = combination.toLowerCase();
        switch (combination) {
            case "ones": return countDice(dice, 1);
            case "twos": return countDice(dice, 2);
            case "threes": return countDice(dice, 3);
            case "fours": return countDice(dice, 4);
            case "fives": return countDice(dice, 5);
            case "sixes": return countDice(dice, 6);
            case "pair": return countPair(dice);
            case "two pairs": return countTwoPairs(dice);
            case "three of a kind": return countThreeOfAKind(dice);
            case "four of a kind": return countFourOfAKind(dice);
            case "small straight": return countSmallStraight(dice);
            case "large straight": return countLargeStraight(dice);
            case "full house": return countFullHouse(dice);
            case "chance": return countChance(dice);
            case "yatzy": return countYatzy(dice);
        }
        return -1;
    }
    
    /**
     * Metodi laskee ykkösistä, kakkosista, kolmosista, nelosista, viitosista ja kuutosista saadut pisteet.
     * @param dice pelaajan nopat
     * @param number noppayhdistelmä
     * @return pelaajan pisteet
     */
    private static int countDice(int[] dice, int number) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice[i] == number) {
                score += number;
            }
        }
        return score;
    }
    
    /**
     * Metodi laskee parista saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countPair(int[] dice) {
        int score = 0;
        for (int i = 1; i < 5; i++) {
            if (dice[i] == dice[i-1]) {
                score = dice[i];
            }
        }
        return 2 * score;
    }
    
    /**
     * Metodi laskee kahdesta parista saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countTwoPairs(int[] dice) {
        if (dice[0] == dice[1] && dice[2] == dice[3] && dice[0] != dice[2]) {
            return 2 * dice[0] + 2 * dice[2];
        } else if (dice[1] == dice[2] && dice[3] == dice[4] && dice[1] != dice[3]) {
            return 2 * dice[1] + 2 * dice[3];
        } else if (dice[0] == dice[1] && dice[3] == dice[4] && dice[0] != dice[3]) {
            return 2 * dice[0] + 2 * dice[3];
        } else {
            return 0;
        }
    }
    
    /**
     * Metodi laskee kolmesta samasta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countThreeOfAKind(int[] dice) {
        if (dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4]) {
            return 3 * dice[2];
        } else {
            return 0;
        }
    }
    
    /**
     * Metodi laskee neljästä samasta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countFourOfAKind(int[] dice) {
        if (dice[0] == dice[3] || dice[1] == dice[4]) {
            return 4 * dice[2];
        } else {
            return 0;
        }
    }
    
    /**
     * Metodi laskee pienestä suorasta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countSmallStraight(int[] dice) {
        for (int i = 0; i < 5; i++) {
            if (dice[i] != i+1) {
                return 0;
            }
        }
        return 15;
    }
    
    /**
     * Metodi laskee isosta suorasta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countLargeStraight(int[] dice) {
        for (int i = 0; i < 5; i++) {
            if (dice[i] != i+2) {
                return 0;
            }
        }
        return 20;
    }
    
    /**
     * Metodi laskee täyskädestä saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countFullHouse(int[] dice) {
        if (dice[0] == dice[2] && dice[3] == dice[4] && dice[0] != dice[4]) {
            return 3 * dice[0] + 2 * dice[4];
        } else if (dice[0] == dice[1] && dice[2] == dice[4] && dice[0] != dice[4]) {
            return 2 * dice[0] + 3 * dice[4];
        } else {
            return 0;
        }
    }
    
    /**
     * Metodi laskee sattumasta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countChance(int[] dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            score += dice[i];
        }
        return score;
    }
    
    /**
     * Metodi laskee Yatzysta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countYatzy(int[] dice) {
        if (dice[0] == dice[4]) {
            return 50;
        } else {
            return 0;
        }
    }
    
}
