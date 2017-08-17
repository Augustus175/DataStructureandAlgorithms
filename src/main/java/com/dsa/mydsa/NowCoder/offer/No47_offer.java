package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-8-10.
 */
public class No47_offer {
    public static void main(String[] args) {
        int[] test = {1, 10, 3, 8, 12, 2, 9, 6, 5, 7, 4, 11, 3, 7, 16, 5};
        System.out.println(getMaxPath(test, 4, 4));
        System.out.println(getMaxPath2(test, 4, 4));
    }

    public static int getMaxPath(int[] matrix, int rows, int cols) {
        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[i - 1][j];
                }
                if (j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(left, up) + matrix[i * rows + j];
            }
        }
        for (int i = 0; i < maxValues.length; i++) {
            for (int j = 0; j < maxValues.length; j++) {
                System.out.print(maxValues[i][j] + " ");
            }
            System.out.println();
        }
        return maxValues[rows - 1][cols - 1];
    }

    public static int getMaxPath2(int[] matrix, int rows, int cols) {
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[j];
                }
                if (j > 0) {
                    left = maxValues[j - 1];
                }
                maxValues[j] = Math.max(left, up) + matrix[i * rows + j];
            }
        }
        for (int i = 0; i < maxValues.length; i++) {
            System.out.print(maxValues[i] + " ");
        }
        System.out.println();
        return maxValues[cols - 1];
    }
}
