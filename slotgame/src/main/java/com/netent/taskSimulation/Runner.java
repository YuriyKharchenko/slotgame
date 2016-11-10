package com.netent.taskSimulation;

import com.netent.tools.Console;
import com.netent.tools.Validator;

public class Runner {
    public static void main(String[] args) {
        Game game = new Game();
        Long startCoins;

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

        long time = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            game.play(startCoins);
        }
        long endTime = System.currentTimeMillis() - time;
        System.out.println("It takes " + endTime + " milliseconds to get statistics for 1.000.000 rounds with " +
                "start budget " + startCoins + " coins!");
    }
}
