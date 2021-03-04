package com.dsa.mydsa.leetcodehot;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        boolean[][] max = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            max[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                max[i][i + 1] = true;
                max[i + 1][i] = true;
            } else {
                max[i][i + 1] = false;
                max[i + 1][i] = false;
            }
        }
        for (int j = 2; j < length; j++) {
            for (int i = 0; i < j - 1; i++) {
                max[i][j] = (s.charAt(i) == s.charAt(j)) && max[i + 1][j - 1];
            }
        }

        String result = "";
        int tmp = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (max[i][j] && (tmp < j - i + 1)) {
                    tmp = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }

        if (tmp == 1) {
            result = s.substring(0, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
//        String longestPalindrome = longestPalindromicSubstring.longestPalindrome("abcba");
        String longestPalindrome = longestPalindromicSubstring.longestPalindrome("cbbd");
//        String longestPalindrome = longestPalindromicSubstring.longestPalindrome("a");
        String str = "a";
        System.out.println(longestPalindrome);
    }
}
