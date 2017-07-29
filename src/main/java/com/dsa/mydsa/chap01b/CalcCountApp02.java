package com.dsa.mydsa.chap01b;

/**
 * Created by zhangzhibo on 2017/5/12.
 */
public class CalcCountApp02 {
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 0};
        theMatrixN(a,4);
        System.out.println(3*a[0]+3*a[2]);
//        System.out.println(3 * a[0]);
//        System.out.println(3 * a[2]);
//        for (int i : a) {
//            System.out.print(i + " ");
//        }

    }
    public static void MatrixMulti(int[] x, int[] y) {
        int x11 = x[0];
        int x12 = x[1];
        int x21 = x[2];
        int x22 = x[3];
        int y11 = y[0];
        int y12 = y[1];
        int y21 = y[2];
        int y22 = y[3];

        x[0] = x11 * y11 + x12 * y21;
        x[1] = x11 * y12 + x12 * y22;
        x[2] = x21 * y11 + x22 * y21;
        x[3] = x21 * y12 + x22 * y22;
    }
    public static void MatrixN(int[] x, int n, int[] tmp) {
        if (n == 0) {
            x[0]=1;
            x[1]=0;
            x[2]=0;
            x[3]=1;
        } else if (n == 1) {
            x[0]=tmp[0];
            x[1]=tmp[1];
            x[2]=tmp[2];
            x[3]=tmp[3];
        } else if (n % 2 == 0) {
            MatrixN(x, n / 2, tmp);
            MatrixMulti(x, x);
        } else {
            MatrixN(x, n / 2, tmp);
            MatrixMulti(x, x);
            MatrixMulti(x, tmp);
        }
    }
    public static void theMatrixN(int[] x, int n) {
        int[] tmp = {x[0],x[1],x[2],x[3]};
        MatrixN(x,n,tmp);
    }
}
