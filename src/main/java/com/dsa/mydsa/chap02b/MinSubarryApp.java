package com.dsa.mydsa.chap02b;

import java.util.Arrays;

/**
 * Created by zhangzhibo on 17-5-26.
 */
public class MinSubarryApp {
    public static void main(String[] args) {
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        int result = MinSubarry(a);
        System.out.println(result);
    }

    public static int MinSubarry(int[] a) {
        int[] sum = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                sum[i] = a[i];
            } else {
                sum[i] = sum[i - 1] + a[i];
            }
        }
        Arrays.sort(sum);
        int result = Math.abs(sum[0]);
        int difference;

        for (int i = 1; i < sum.length; i++) {
            difference = Math.abs(sum[i] - sum[i - 1]);
            result = Math.min(result, difference);
        }
        return result;

    }
}
