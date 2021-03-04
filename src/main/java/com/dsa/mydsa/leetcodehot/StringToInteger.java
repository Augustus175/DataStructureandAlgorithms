package com.dsa.mydsa.leetcodehot;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.io.StringWriter;

public class StringToInteger {
    public int myAtoi(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while ((i < s.length()) && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if ((i < s.length()) && s.charAt(i) == '-') {
            i++;
            sign = -1;
        } else if ((i < s.length()) && s.charAt(i) == '+') {
            i++;
        }
        int result = 0;
        while ((i < s.length()) && (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
            int r = (s.charAt(i) - '0');
            int t = result * 10 + (s.charAt(i) - '0');
            int tmp = ((result * 10 + r) - r) / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && r > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * (s.charAt(i) - '0');
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        String s = "42";
        s = "   -42";
        s = "4193 with words";
        s = "-91283472332";
        s = "-+12";
        s = "21474836460";
        s = " ";
        s = "2147483646";
        s = "2147483648";
        s = "-91283472332";
        s = "-2147483647";
        int res = stringToInteger.myAtoi(s);
        System.out.println(res);
    }
}
