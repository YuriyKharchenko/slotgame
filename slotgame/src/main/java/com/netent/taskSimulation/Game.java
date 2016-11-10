package com.netent.taskSimulation;

import com.netent.tools.Engine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Game {


    public void play(Long startCoins) {

        int betAmount = 10;
        int normalRoundNumber = 0;
        int freeRoundNumber = 0;
        int winCoinsInNormalRound = 0;
        int winCoinsInFreeRound = 0;
        int freeRound = 0;
        boolean quit = false;


        while (!quit) {
            while (true) {
                if (startCoins > 0) {
                    normalRoundNumber++;
                    startCoins -= betAmount;

                    Long resNormal = Engine.playNormal();
                    winCoinsInNormalRound += resNormal;
                    startCoins += resNormal;
                    if (Engine.winBonusRound()) freeRound++;

                    while (freeRound > 0) {
                        freeRoundNumber++;
                        freeRound--;
                        Long resFree = Engine.playFree();
                        winCoinsInFreeRound += resFree;
                        startCoins += resFree;
                        if (Engine.winBonusRound()) freeRound++;
                    }
                } else {
                    break;
                }
                quit = true;
            }

            double totalNormalBet = betAmount * normalRoundNumber;
            double rtp = (winCoinsInNormalRound + winCoinsInFreeRound) / totalNormalBet;
            double rtpRounded = new BigDecimal(rtp).setScale(3, RoundingMode.UP).doubleValue();
            System.out.println("You played " + normalRoundNumber + " Normal rounds and " +
                    freeRoundNumber + " Free rounds");
            System.out.println("You won " + winCoinsInNormalRound + " coins in Normal rounds and " +
                    winCoinsInFreeRound + " coins in Free rounds");
            System.out.println("RTP (total win/ total Normal bet) : " + rtpRounded);
        }
    }

}
