package textui;

import java.util.Scanner;

/**
 * Tekstikäyttöliittymä pelille.
 */
public class Main {
    
    /**
     * Tulostaa pelaajan pistetaulukon.
     * @param scores pistetaulukko
     */
    public static void printScores(int[] scores) {
        System.out.println("Ones: " + scores[0]);
        System.out.println("Twos: " + scores[1]);
        System.out.println("Threes: " + scores[2]);
        System.out.println("Fours: " + scores[3]);
        System.out.println("Fives: " + scores[4]);
        System.out.println("Sixes: " + scores[5]);
        System.out.println("Upper total: " + scores[6]);
        System.out.println("Bonus: " + scores[7]);
        System.out.println("Pair: " + scores[8]);
        System.out.println("Two pairs: " + scores[9]);
        System.out.println("Three of a kind: " + scores[10]);
        System.out.println("Four of a kind: " + scores[11]);
        System.out.println("Small straight: " + scores[12]);
        System.out.println("Large straight: " + scores[13]);
        System.out.println("Full house: " + scores[14]);
        System.out.println("Chance: " + scores[15]);
        System.out.println("Yatzy: " + scores[16]);
        System.out.println("TOTAL: " + scores[17]);
    }
    
    /**
     * Main-metodi.
     * @param args komentoriviargumentit
     */
    public static void main(String[] args) {
        logic.Game yatzy = new logic.Game();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to a game of Yatzy!");
        System.out.print("How many players wish to play? ");
        int num = input.nextInt();
        while (num < 1 || num > 6) {
            System.out.print("Please enter a number between one and six: ");
            num = input.nextInt();
        }
        for (int i = 0; i < num; i++) {
            String name = input.nextLine();
            while (name.equals("")) {
                System.out.print("Player " + (i+1) + ", please enter your name: ");
                name = input.nextLine();
            }
            yatzy.addPlayer(name);
        }
        System.out.println("Let the game begin!");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < num; j++) {
                printScores(yatzy.players.get(j).getScores().scores);
                for (int k = 0; k < 3; k++) {
                    yatzy.rollDice();
                    System.out.println(yatzy.players.get(j).getName() + " got the following dice:");
                    for (int l = 0; l < 5; l++) {
                        System.out.print(yatzy.dice[l].getValue() + " ");
                    }
                    System.out.println();
                    if (k != 2) {
                        String answer;
                        for (int l = 0; l < 5; l++) {
                            if (!yatzy.dice[l].isLocked()) {
                                System.out.print("Lock dice number " + (l+1) + "? (y/n) ");
                                answer = input.nextLine();
                                if (answer.toLowerCase().startsWith("y")) {
                                    yatzy.dice[l].lock();
                                }
                            } else {
                                System.out.print("Unlock dice number " + (l+1) + "? (y/n) ");
                                answer = input.nextLine();
                                if (answer.toLowerCase().startsWith("y")) {
                                    yatzy.dice[l].unlock();
                                }
                            }
                        }
                    } else {
                        System.out.print("Which combination to use? ");
                        String combination = input.nextLine().toLowerCase();
                        while (yatzy.players.get(j).getScores().getScore(combination) != -1) {
                            System.out.print("Please enter a valid combination! ");
                            combination = input.nextLine().toLowerCase();
                        }
                        yatzy.putScore(combination, yatzy.players.get(j));
                        yatzy.freeDice();
                    }
                }
            }
        }
        System.out.println("Game over!");
        int player = 0;
        int score = 0;
        for (int i = 0; i < num; i++) {
            yatzy.players.get(i).getScores().setUpperTotal();
            yatzy.players.get(i).getScores().setTotal();
            if (score < yatzy.players.get(i).getScores().scores[17]) {
                player = i;
                score = yatzy.players.get(i).getScores().scores[17];
            }
            System.out.println(yatzy.players.get(i).getName() + " got the following scores: ");
            printScores(yatzy.players.get(i).getScores().scores);
        }
        System.out.println(yatzy.players.get(player).getName() + " won! Congratulations!");
    }
    
}
