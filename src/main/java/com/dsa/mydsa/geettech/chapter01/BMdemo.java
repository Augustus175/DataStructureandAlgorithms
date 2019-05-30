package com.dsa.mydsa.geettech.chapter01;


public class BMdemo {
    public static int pattern(String text, String pattern) {
        int i = 0;
        int m = pattern.length();
        while (i <= text.length() - m) {
            int j;
            int k = i + m - 1;
            for (j = m - 1; j >= 0 && text.charAt(k--) == pattern.charAt(j); j--) {
                System.out.println(j);
            }
            ;
            if (j < 0) {
                return i;
            } else {
                i += step();
            }
        }
        return -1;
    }

    private static int step() {
        return 1;
    }

    public static void main(String[] args) {
        int pattern = pattern("abcabcabcaaa", "aaa");
        System.out.println(pattern);
    }
}
