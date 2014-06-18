package logic;

/**
 * Represents a score table of a player.
 */
public class Scores {
    
    /**
     * The score table.
     */
    public int[] scores;
    
    /**
     * Creates a new score table.
     */
    public Scores() {
        this.scores = new int[18];
        for (int i = 0; i < 18; i++) {
            this.scores[i] = -1;
        }
    }
    
    /**
     * Method for translating a dice combination as a string to an integer.
     * @param combination Dice combination.
     * @return Combination as integer.
     */
    public static int combinationToInteger(String combination) {
        combination = combination.toLowerCase();
        switch (combination) {
            case "ones": return 0;
            case "twos": return 1;
            case "threes": return 2;
            case "fours": return 3;
            case "fives": return 4;
            case "sixes": return 5;
            case "upper total": return 6;
            case "bonus": return 7;
            case "pair": return 8;
            case "two pairs": return 9;
            case "three of a kind": return 10;
            case "four of a kind": return 11;
            case "small straight": return 12;
            case "large straight": return 13;
            case "full house": return 14;
            case "chance": return 15;
            case "yatzy": return 16;
            case "total": return 17;
        }
        return -1;
    }
    
    /**
     * Returns the score for a given dice combination.
     * @param combination Dice combination.
     * @return Score.
     */
    public int getScore(String combination) {
        return this.scores[combinationToInteger(combination)];
    }
    
    /**
     * Sets the score for a given dice combination.
     * @param score Score.
     * @param combination Dice combination.
     */
    public void setScore(int score, String combination) {
        this.scores[combinationToInteger(combination)] = score;
    }
    
    /**
     * Counts the sum of the upper section of the score table and sets its value.
     */
    public void setUpperTotal() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += this.scores[i];
        }
        this.scores[6] = sum;
        if (sum >= 63) {
            this.scores[7] = 50;
        } else {
            this.scores[7] = 0;
        }
    }
    
    /**
     * Counts the total sum of the score table and sets its value.
     */
    public void setTotal() {
        int sum = 0;
        for (int i = 6; i < 17; i++) {
            sum += this.scores[i];
        }
        this.scores[17] = sum;
    }
    
}
