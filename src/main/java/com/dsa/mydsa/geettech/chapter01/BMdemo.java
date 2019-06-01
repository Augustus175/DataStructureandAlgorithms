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

    private int Better() {
        return -1;
    }

    private void BG(String pattern) {
        int m = pattern.length();
        int[] BG = new int[m];
        boolean[] prefix = new boolean[m];
        for (int i = 0; i < m - 1; i++) {
            int k = 0;
            int j = i;
            while (j >= 0 && pattern.charAt(j) == pattern.charAt(m - k)) {
                --j;
                ++k;
                BG[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    private static int step() {
        return 1;
    }

    public static void main(String[] args) {
        int pattern = pattern("abcabcabcaaa", "aaa");
        System.out.println(pattern);
    }
}
