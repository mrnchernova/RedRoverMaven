package org.example;

import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {

        System.out.println(apacheCommonLeftPad("  1"));
    }

    public static int getSum(int a, int b) {
        return a + b;
    }

    public static String apacheCommonLeftPad(String value) {
        return StringUtils.leftPad(value.trim(), value.length(), "0");
    }
}