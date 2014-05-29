package textui;

import java.util.Scanner;

public class Main {
    
    public static void printScorecard(int[] scores) {
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
    
    public static void main(String[] args) {
        logic.Game yatzy = new logic.Game();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to a single player game of Yatzy!");
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        while (name.equals("")) {
            System.out.print("Please enter a valid name: ");
            name = input.nextLine();
        }
        yatzy.singlePlayer.setName(name);
        System.out.println(name + ", let the game begin!");
        for (int i = 0; i < 15; i++) {
            printScorecard(yatzy.singlePlayer.getScorecard().scores);
            for (int j = 0; j < 3; j++) {
                yatzy.rollDice();
                System.out.println(name + " got the following dice:");
                for (int k = 0; k < 5; k++) {
                    System.out.print(yatzy.dice[k].getValue() + " ");
                }
                System.out.println();
                if (j != 2) {
                    String answer = "";
                    for (int k = 0; k < 5; k++) {
                        if (!yatzy.dice[k].isLocked()) {
                            System.out.print("Lock dice number " + (k+1) + "? (y/n) ");
                            answer = input.nextLine();
                            if (answer.toLowerCase().startsWith("y")) {
                                yatzy.dice[k].lock();
                            }
                        } else {
                            System.out.print("Unlock dice number " + (k+1) + "? (y/n) ");
                            answer = input.nextLine();
                            if (answer.toLowerCase().startsWith("y")) {
                                yatzy.dice[k].unlock();
                            }
                        }
                    }
                } else {
                    System.out.print("Which combination to use? ");
                    String combination = input.nextLine().toLowerCase();
                    while (yatzy.singlePlayer.getScorecard().getScore(combination) != -1) {
                        System.out.print("Please enter a valid combination! ");
                        combination = input.nextLine().toLowerCase();
                    }
                    yatzy.putScore(combination);
                    yatzy.freeDice();
                }
            }
        }
        yatzy.singlePlayer.getScorecard().setUpperTotal();
        yatzy.singlePlayer.getScorecard().setTotal();
        System.out.println("Game over!");
        printScorecard(yatzy.singlePlayer.getScorecard().scores);
    }
    
}
