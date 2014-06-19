package logic;

import java.util.Arrays;

/**
 * Contains a method for counting the player's points during the game.
 */
public class Calculator {
        
    /**
     * Counts the player's points with the given dice combination.
     * @param dice Player's dice.
     * @param combination Dice combination.
     * @return Player's points.
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
     * Counts the player's points from Ones, Twos, Threes, Fours, Fives and Sixes.
     * @param dice Player's dice.
     * @param number Dice combination (1-6).
     * @return Player's points.
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
     * Counts the player's points from Pair.
     * @param dice Player's dice.
     * @return Player's points.
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
     * Counts the player's points from Two Pairs.
     * @param dice Player's dice.
     * @return Player's points.
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
     * Counts the player's points from Three of a Kind.
     * @param dice Player's dice.
     * @return Player's points.
     */
    private static int countThreeOfAKind(int[] dice) {
        if (dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4]) {
            return 3 * dice[2];
        } else {
            return 0;
        }
    }
    
    /**
     * Counts the player's points from Four of a Kind.
     * @param dice Player's dice.
     * @return Player's points.
     */
    private static int countFourOfAKind(int[] dice) {
        if (dice[0] == dice[3] || dice[1] == dice[4]) {
            return 4 * dice[2];
        } else {
            return 0;
        }
    }
    
    /**
     * Counts the player's points from Small Straight.
     * @param dice Player's dice.
     * @return Player's points.
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
     * Counts the player's points from Large Straight.
     * @param dice Player's dice.
     * @return Player's points.
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
     * Counts the player's points from Full House.
     * @param dice Player's dice.
     * @return Player's points.
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
     * Counts the player's points from Chance.
     * @param dice Player's dice.
     * @return Player's points.
     */
    private static int countChance(int[] dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            score += dice[i];
        }
        return score;
    }
    
    /**
     * Counts the player's points from Yatzy.
     * @param dice Player's dice.
     * @return Player's points.
     */
    private static int countYatzy(int[] dice) {
        if (dice[0] == dice[4]) {
            return 50;
        } else {
            return 0;
        }
    }
    
}
