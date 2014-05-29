package logic;

public class Scores {
    
    public int[] scores;
    
    public Scores() {
        this.scores = new int[18];
        for (int i = 0; i < 18; i++) {
            this.scores[i] = -1;
        }
    }
    
    public void setScore(int score, String combination) {
        switch (combination) {
            case "ones": scores[0] = score; break;
            case "twos": scores[1] = score; break;
            case "threes": scores[2] = score; break;
            case "fours": scores[3] = score; break;
            case "fives": scores[4] = score; break;
            case "sixes": scores[5] = score; break;
            case "pair": scores[8] = score; break;
            case "two pairs": scores[9] = score; break;
            case "three of a kind": scores[10] = score; break;
            case "four of a kind": scores[11] = score; break;
            case "small straight": scores[12] = score; break;
            case "large straight": scores[13] = score; break;
            case "full house": scores[14] = score; break;
            case "chance": scores[15] = score; break;
            case "yatzy": scores[16] = score; break;
        }
    }
    
    public int getScore(String combination) {
        switch (combination) {
            case "ones": return scores[0];
            case "twos": return scores[1];
            case "threes": return scores[2];
            case "fours": return scores[3];
            case "fives": return scores[4];
            case "sixes": return scores[5];
            case "pair": return scores[8];
            case "two pairs": return scores[9];
            case "three of a kind": return scores[10];
            case "four of a kind": return scores[11];
            case "small straight": return scores[12];
            case "large straight": return scores[13];
            case "full house": return scores[14];
            case "chance": return scores[15];
            case "yatzy": return scores[16];
        }
        return 0;
    }
    
    public void setUpperTotal() {
        boolean check = true;
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += this.scores[i];
            if (this.scores[i] == -1) {
                check = false;
            }
        }
        if (check) {
            this.scores[6] = sum;
            if (sum >= 63) {
                this.scores[7] = 50;
            } else {
                this.scores[7] = 0;
            }
        }
    }
    
    public void setTotal() {
        boolean check = true;
        int sum = 0;
        for (int i = 6; i < 16; i++) {
            sum += this.scores[i];
            if (this.scores[i] == -1) {
                check = false;
            }
        }
        if (check) {
            this.scores[17] = sum;
        }
    }
    
}
