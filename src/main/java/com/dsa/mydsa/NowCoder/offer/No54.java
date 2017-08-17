package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-5.
 */
public class No54 {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp = tmp * A[i + 1];
            B[i] = B[i] * tmp;
        }
        return B;
    }
}
