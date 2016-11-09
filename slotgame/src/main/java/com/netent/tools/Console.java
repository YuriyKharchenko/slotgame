package com.netent.tools;

import java.util.Scanner;

public class Console {

    private static Scanner consoleReader;

    public static String read(String welcomeMessage) {
        System.out.println(welcomeMessage);
        consoleReader = new Scanner(System.in);
        String result = consoleReader.nextLine();
        return result;
    }

    public static Long parseNumber(String expression) {

        String temp = "";
        for (char c : expression.toCharArray()) {
            if (c == ' ') continue;

            if ((c >= '0' && c <= '9') || (c == '.')) {
                temp += c;
            } else if ((c == 'q')) continue;

            else {
                throw new RuntimeException("Please enter correct number");
            }
        }
        return Long.parseLong(temp);

    }


}
