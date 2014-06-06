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
        int score = 0;
        int pair = countPair(dice);
        for (int i = 1; i < 5; i++) {
            if (dice[i] != pair/2 && dice[i] == dice[i-1]) {
                score = dice[i];
            }
        }
        if (pair != 0 && score != 0) {
            return 2 * score + pair;
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
        int score = 0;
        for (int i = 2; i < 5; i++) {
            if (dice[i-1] == dice[i-2] && dice[i] == dice[i-1]) {
                score = dice[i];
            }
        }
        return 3 * score;
    }
    
    /**
     * Metodi laskee neljästä samasta saadut pisteet.
     * @param dice pelaajan nopat
     * @return pelaajan pisteet
     */
    private static int countFourOfAKind(int[] dice) {
        int score = 0;
        for (int i = 3; i < 5; i++) {
            if (dice[i-2] == dice[i-3] && dice[i-1] == dice[i-2] && dice[i] == dice[i-1]) {
                score = dice[i];
            }
        }
        return 4 * score;
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
        int score = 0;
        int threeOfAKind = countThreeOfAKind(dice);
        for (int i = 1; i < 5; i++) {
            if (dice[i] != threeOfAKind/3 && dice[i] == dice[i-1]) {
                score = dice[i];
            }
        }
        if (threeOfAKind != 0 && score != 0) {
            return 2 * score + threeOfAKind;
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
        for (int i = 1; i < 5; i++) {
            if (dice[i] != dice[i-1]) {
                return 0;
            }
        }
        return 50;
    }
    
}
