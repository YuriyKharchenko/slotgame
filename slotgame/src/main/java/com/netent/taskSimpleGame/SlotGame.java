package com.netent.taskSimpleGame;

import com.netent.tools.Console;
import com.netent.tools.Engine;
import com.netent.tools.Validator;

public class SlotGame {
    public static void main(String[] args) {

        System.out.println("NETENT Slot Machine");//Name of slot machine
        System.out.print("How to play\n\n");
        System.out.print("1.Set the amount of coins in your pocket\n");
        System.out.print("2.Type 'Play' \n");
        System.out.print("3.Collect winnings from tray or bet again\n");
        System.out.print("Good luck!\n\n");


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
                        Long resNormal = Engine.playNormal();
                        startCoins += resNormal;
                        if (Engine.winBonusRound()) freeRound++;


                        if (freeRound <= 0) {
                            System.out.println("You don't have Free rounds to play");
                        } else {
                            System.out.println("You play Free round ... \n");
                            Long resFree = Engine.playFree();
                            startCoins += resFree;
                            freeRound--;
                            if (Engine.winBonusRound()) freeRound++;

                        }
                        System.out.println("Now you have " + startCoins + " coins in your pocket and " + freeRound +
                                " free  rounds");

                    } else if (Console.read("\n - In order to play one more time press  \"Enter\". \n " +
                            "- For Exit press \"q\" " +
                            "and press \"Enter\" ").equals("q")) {
                        quit = true;
                        break;
                    } else continue;
                } else {
                    System.out.println("Your pocket is empty :( \n Please try again later. See you next time!");
                    System.exit(0);
                }

            }
        }
    }
}
