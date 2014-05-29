package logic;

public class Player {
    
    private String name;
    private Scores scorecard;
    
    public Player() {
        this.name = "";
        this.scorecard = new Scores();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Scores getScorecard() {
        return this.scorecard;
    }
    
}
