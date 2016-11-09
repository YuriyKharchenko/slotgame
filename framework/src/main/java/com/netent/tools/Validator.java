package com.netent.tools;

public class Validator {

    public static boolean isNumber(String expression) {
        for (char c : expression.toCharArray()) {
            if (c == ' ') continue;
            if ((c >= '0' && c <= '9') || (c == '.')) return true;
            else return false;
        }
        return false;
    }
}

