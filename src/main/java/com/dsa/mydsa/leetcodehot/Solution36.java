package com.dsa.mydsa.leetcodehot;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[][] columns = new int[9][9];
        int[][] max = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int c = board[i][j] - '0' - 1;
                if (c == -3) {
                    continue;
                }
                if (row[c] == 0) {
                    row[c] = 1;
                } else {
                    return false;
                }
                if (columns[j][c] == 0) {
                    columns[j][c] = 1;
                } else {
                    return false;
                }
                if (max[j / 3 + 3 * (i / 3)][c] == 0) {
                    max[j / 3 + 3 * (i / 3)][c] = 1;
                } else {
                    return false;
                }
            }
            row = new int[9];
        }
        return true;
    }
}
