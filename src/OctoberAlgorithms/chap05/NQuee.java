package OctoberAlgorithms.chap05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class NQuee {
    public static void main(String[] args) {
        NqueeSolution nq = new NqueeSolution(10);
        System.out.println(nq.NQueeSolution());
    }
}

class NqueeSolution {

    int num;
    int[] path;
    boolean[] colarray;
    boolean[] LeadDiagonal;
    boolean[] SecondDiagonal;
    List<int[]> result = new ArrayList<>();

    public NqueeSolution(int num) {
        this.num = num;
        path = new int[num];
        colarray = new boolean[num];
        LeadDiagonal = new boolean[2 * num - 1];
        SecondDiagonal = new boolean[2 * num - 1];
    }

    public int NQueeSolution() {
        NQueeSol(path, 0);
        return result.size();
    }

    public void NQueeSol(int[] path, int row) {
        if (row == num) {
            result.add(path);
            return;
        }
        for (int col = 0; col < num; col++) {
            if (CanLay(row, col)) {
                path[col] = col;
                colarray[col] = true;
                LeadDiagonal[num - 1 + row - col] = true;
                SecondDiagonal[row + col] = true;
                NQueeSol(path, row + 1);


                colarray[col] = false;
                LeadDiagonal[num - 1 + row - col] = false;
                SecondDiagonal[row + col] = false;
            }
        }
    }


    public boolean CanLay(int row, int col) {
        return (!colarray[col] && !LeadDiagonal[num - 1 + row - col] && !SecondDiagonal[row + col]);
    }
}
