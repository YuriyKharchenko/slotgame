package com.netent.taskSimulation;

import com.netent.tools.Engine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;


public class Game {

    public void play(Long startCoins) {

        int betAmount = 10;
        int normalRoundNumber = 0;
        int freeRoundNumber = 0;
        int winCoinsInFreeRound = 0;
        boolean quit = false;

        while (!quit) {
            while (true) {
                if (startCoins > 0) {
                    normalRoundNumber++;
                    startCoins -= betAmount;
                    if (Engine.winBonusRound()) {
                        freeRoundNumber++;
                        int secretBoxNumber = Engine.setRandBox();
                        ArrayList<Integer> bonusRoundList = new ArrayList();
                        int userNumber = 0;
                        boolean exit = false;
                        while (!exit) {
                            int chance = userRandNumber();
                            if (bonusRoundList.contains(chance)) {

                            } else {
                                bonusRoundList.add(chance);
                                userNumber = chance;
                            }

                            if (userNumber != secretBoxNumber) {
                                startCoins += 5;
                                winCoinsInFreeRound += 5;
                            } else {
                                exit = true;
                            }
                        }
                    }
                } else {
                    break;
                }

                quit = true;
            }
            double totalNormalBet = betAmount*normalRoundNumber;
            double rtp = winCoinsInFreeRound/totalNormalBet;
            double rtpRounded = new BigDecimal(rtp).setScale(3, RoundingMode.UP).doubleValue();
            System.out.println("Number of Normal rounds :" + normalRoundNumber);
            System.out.println("Number of Free rounds : " + freeRoundNumber);
            System.out.println("You won " + winCoinsInFreeRound + " coins in Free rounds");
            System.out.println("RTP (total win/ total Normal bet) : " + rtpRounded);
        }
    }

    private int userRandNumber() {
        Random random = new Random();
        int randomBoxNumber = random.nextInt((5 - 1) + 1) + 1;
        return randomBoxNumber;
    }
}
