package com.netent.tools;

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

    public static boolean winFreeRound() {
        double chance = Math.random() * 100;
        if (chance < 10) {
            System.out.println("Also you win additional Free round! :)");
            return true;
        } else {
            System.out.println("Also you didn't win additional Free round! :(");
            return false;
        }
    }
}
