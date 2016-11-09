package com.netent.tools;

import java.util.Random;

public class Engine {

    public static Long playNormal() {
        double chance = Math.random() * 100;
        if (chance < 30) {
            System.out.println("You WIN!");
            return 30L;
        } else {
            System.out.println("OOPS, GAME OVER");
            return 0L;
        }

    }

    public static Long playFree() {
        double chance = Math.random() * 100;
        if (chance < 30) {
            System.out.println("You WIN!");
            return 20L;
        } else {
            System.out.println("OOPS, GAME OVER");
            return 0L;
        }

    }

    public static boolean winBonusRound() {
        double chance = Math.random() * 100;
        if (chance <= 10) {
            System.out.println("You win additional round! :)");
            return true;
        } else {
            System.out.println("You didn't win additional round! :(");
            return false;
        }
    }

    public static int setRandBox(){
        Random random = new Random();
        int randomBoxNumber = random.nextInt((5 - 1) + 1) + 1;
        return randomBoxNumber;
    }

    public static void printBoxes() {

        System.out.println("You have 5 boxes, choose one of them by typing its number : ");
        System.out.println(" ------ ------ ------ ------ ------");
        System.out.println(" |     |" + "|     |" + "|     |" + "|     |" + "|     |");
        System.out.println(" |  1  |" + "|  2  |" + "|  3  |" + "|  4  |" + "|  5  |");
        System.out.println(" |     |" + "|     |" + "|     |" + "|     |" + "|     |");
        System.out.println(" ------ ------ ------ ------ ------");
    }
}
