package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int a = 0;
        int b = matrix[0].length - 1;
        int c = matrix.length - 1;
        int d = 0;
        List<Integer> result = new ArrayList<>();
        int numEle = matrix.length * matrix[0].length;
        while (a <= c && b >= d) {
            numEle = printMatrix(matrix, a, b, c, d, numEle, result);
            a++;
            b--;
            c--;
            d++;
        }

        return result;
    }

    private int printMatrix(int[][] matrix, int a, int b, int c, int d, int numEle, List<Integer> result) {
        for (int i = d; i <= b && numEle >= 1; i++) {
            result.add(matrix[a][i]);
            numEle--;
        }
        for (int i = a + 1; i <= c && numEle >= 1; i++) {
            result.add(matrix[i][b]);
            numEle--;
        }
        for (int i = b - 1; i >= d && numEle >= 1; i--) {
            result.add(matrix[c][i]);
            numEle--;
        }
        for (int i = c - 1; i >= a + 1 && numEle >= 1; i--) {
            result.add(matrix[i][d]);
            numEle--;
        }
        return numEle;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution54 solution54 = new Solution54();
        List<Integer> list = solution54.spiralOrder(matrix);
        System.out.println(list);
    }

}
