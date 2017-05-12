package OctoberAlgorithms.chap01b;

/**
 * Created by zhangzhibo on 2017/5/12.
 */
public class CalcCountApp02 {
    public static void main(String[] args) {
        int[] a = {2, 1, 2, 0};
        int[] result = MatrixN(a, 4);
        System.out.println(3 * result[0]);
        System.out.println(3 * result[1]);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] MatrixMulti(int[] x, int[] y) {
        int x11 = x[0];
        int x12 = x[1];
        int x21 = x[2];
        int x22 = x[3];
        int y11 = y[0];
        int y12 = y[1];
        int y21 = y[2];
        int y22 = y[3];
        int[] result = new int[4];
        result[0] = x11 * y11 + x12 * y21;
        result[1] = x11 * y12 + x12 * y22;
        result[2] = x21 * y11 + x22 * y21;
        result[3] = x21 * y12 + x22 * y22;
        return result;
    }

    public static int[] MatrixN(int[] x, int n) {
//        int[] result = {1,0,0,1};
        int[] result = new int[4];
        if (n == 0) {
            result[0] = 1;
            result[1] = 0;
            result[2] = 0;
            result[3] = 1;
        } else if (n == 1) {
            result = x;
        } else if (n % 2 == 0) {
            MatrixN(x, n / 2);
            result = MatrixMulti(x, x);
        } else {
            int[] t = {x[0], x[1], x[2], x[3]};
            int[] tmp1 = MatrixN(x, n / 2);
            int[] tmp2 = MatrixMulti(tmp1, tmp1);
            result = MatrixMulti(tmp2, t);
        }
        return result;
    }
}
