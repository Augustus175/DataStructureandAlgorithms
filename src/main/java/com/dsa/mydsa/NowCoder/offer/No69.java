package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No69 {
    public static void main(String[] args) {
        System.out.println(movingCount(5,10,10));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows + cols; i++) {
            visited[i] = false;
        }
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row, col + 1, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row - 1, col, visited);
        }
        return count;
    }

    public static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return (col >= 0 && col < cols && row >= 0 && row < rows && !visited[row * cols + col] && (getDigistSum(row) + getDigistSum(col) <= threshold));
    }

    public static int getDigistSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
