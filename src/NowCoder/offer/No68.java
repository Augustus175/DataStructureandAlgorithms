package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class No68 {
    public static void main(String[] args) {
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCCED".toCharArray();
        System.out.println(hasPath(matrix,3,4,str));
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
}
