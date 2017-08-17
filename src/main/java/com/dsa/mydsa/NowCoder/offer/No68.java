package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No68 {
    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCCED".toCharArray();
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            visited[i] = false;
        }
        int[] pathlength = {0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathlength)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited, int row, int col, int[] pathlength) {
        if (pathlength[0] == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row * cols + col] == str[pathlength[0]] && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            pathlength[0]++;
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathlength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathlength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathlength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathlength);
            if (!hasPath) {
                pathlength[0]--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }


    public boolean hasPath2(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        boolean haspath = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                haspath = hasPathCore(matrix, rows, cols, i, j, visited, str, 0);
                if (haspath) {
                    return haspath;
                }
            }
        }
        return false;


    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, boolean[] visited, char[] str, int i) {
        boolean haspath = false;
        if (i == str.length) {
            return true;
        }
        if (col >= 0 && row >= 0 && row < rows && col < cols && (row * cols + col) < matrix.length && (!visited[row * cols + col]) && str[i] == matrix[row * cols + col]) {
            visited[row * cols + col] = true;
            i++;
            haspath = hasPathCore(matrix, rows, cols, row + 1, col, visited, str, i) || hasPathCore(matrix, rows, cols, row, col + 1, visited, str, i)
                    || hasPathCore(matrix, rows, cols, row - 1, col, visited, str, i) || hasPathCore(matrix, rows, cols, row, col - 1, visited, str, i);
            if (!haspath) {
                i--;
                visited[row * cols + col] = false;
            }
        }
        return haspath;
    }
}
