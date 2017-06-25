package NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-6-25.
 */
public class No22 {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;

        while (rows > start * 2 && columns > start * 2) {
            printMatrixInCircle(matrix, rows, columns, start);
            start++;
        }
        return result;
    }
    public void printMatrixInCircle(int[][] matrix, int rows, int columns, int start) {
        for (int i = start; i < columns - start; i++) {
            result.add(matrix[start][i]);
        }
        for (int j = start+1; j < rows - start; j++) {
            result.add(matrix[j][columns - start - 1]);
        }
        for (int m = columns - start - 2; m >= start && rows - start - 1 > start; m--) {
            result.add(matrix[rows - start - 1][m]);
        }
        for (int n = rows - start - 2; n > start && columns - start - 1 > start; n--) {
            result.add(matrix[n][start]);
        }
    }
}
