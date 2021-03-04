package com.dsa.mydsa.leetcodehot;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean max[][] = new boolean[s.length() + 1][p.length() + 1];
        max[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            char c = p.charAt(i - 1);
            if (i > 1) {
                if (c == '*') {
                    max[0][i] = max[0][i - 2];
                } else {
                    max[0][1] = false;
                }
            } else {
                max[0][i] = (c == '*');
            }
        }
        for (int row = 1; row < s.length(); row++) {
            char sc = s.charAt(row - 1);
            for (int col = 1; col < p.length(); col++) {
                char pc = p.charAt(col - 1);
                if (sc == pc || pc == '.') {
                    max[row][col] = max[row - 1][col - 1];
                } else if (pc == '*') {
                    if (col > 1) {
                        if (max[row][col - 2]) {
                            max[row][col] = true;
                        } else if (sc == p.charAt(col - 2) || p.charAt(col - 2) == '.') {
                            max[row][col] = max[row - 1][col];
                        }
                    }
                }
            }
        }
        return max[s.length() - 1][p.length() - 1];
    }
}
