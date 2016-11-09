package com.netent;

import com.netent.tools.Console;
import com.netent.tools.Engine;
import com.netent.tools.Validator;

import java.util.Scanner;

public class Bonusgame {
    public static void main(String[] args) {

        System.out.println("NETENT Bonusgame");//Name of slot machine
        System.out.print("How to play\n\n");
        System.out.print("1.Set the amount of coins in your pocket\n");
        System.out.print("2.Type 'Play' \n");
        System.out.print("3.Collect winnings from tray or bet again\n");
        System.out.print("Good luck!\n\n");


        Scanner input = new Scanner(System.in);
        Long startCoins;
        int betAmount = 10;
        int normalRound = 0;
        int freeRound = 0;
        boolean quit = false;
        String temp;

        while (true) {
            String console = Console.read("Please enter your budget :");

            if (Validator.isNumber(console)) {
                startCoins = Long.valueOf(console);
                break;
            } else {
                System.out.println("Wrong number. Please try again.");
                continue;
            }
        }
        while (!quit) {

            while (true) {
                if (startCoins > 0) {
                    temp = Console.read("Please enter 'Play' to start Game or press Enter to proceed to exit:");
                    if (temp.equals("Play")) {
                        startCoins -= betAmount;
                        System.out.println("You play Normal round : " + ++normalRound + " \n" + "Your bet is : " +
                                betAmount);

                        if (Engine.winBonusRound()) {
                            freeRound++;
                            System.out.println("You play Bonus round ... \n ");
                            int secretBoxNumber = Engine.setRandBox();
                            System.out.println(secretBoxNumber);
                            Engine.printBoxes();
                            System.out.println("Please enter box number :");

                            while (true) {
                                String numberInput = Console.read("Guess number :");
                                int number = Integer.valueOf(numberInput);
                                if (Validator.isNumber(numberInput) && (number > 0 && number <= 5)) {
                                    if (number != secretBoxNumber) {
                                        startCoins += 5;
                                        System.out.println("You win 5 coins! :)");

                                    } else {
                                        System.out.println("OOPS, GAME OVER");
                                        break;
                                    }
                                } else {
                                    System.out.println("Wrong number. Please try again.");
                                    continue;
                                }
                            }

                            System.out.println("Now you have " + startCoins + " coins in your pocket.");
                        } else {
                            System.out.println("Now you have " + startCoins + " coins in your pocket.");
                            continue;
                        }
                    } else if (Console.read("\n - In order to play one more time press  \"Enter\". \n " +
                            "- For Exit press \"q\" " +
                            "and press \"Enter\" ").equals("q")) {
                        quit = true;
                        break;
                    }
                } else {
                    System.out.println("Your pocket is empty :( \n Please try again later. See you next time!");
                    System.exit(0);
                }
            }
        }
    }
}
