package OctoberAlgorithms.chap02a;

/**
 * Created by zhangzhibo on 17-5-19.
 */
public class NumofSquare {
    public static void main(String[] args) {
        int[][] chess = new int[19][19];
        for (int i = 1; i < 19; i++) {
            for (int j = 1; j < 19; j++) {
                if(i==j)
                {
                    chess[i][j] = chess[i-1][j]+1;
                }else {
                    chess[i][j] =Math.min(i,j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                count = count + chess[i][j];
                if (chess[i][j]<10)
                {
                    System.out.print(chess[i][j] + "  ");
                }else{
                    System.out.print(chess[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println(count);
    }
}
