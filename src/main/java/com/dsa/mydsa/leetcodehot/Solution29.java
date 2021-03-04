package com.dsa.mydsa.leetcodehot;

public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        if (a > b) {
            return 0;
        }
        int ans = div(a, b);
        return sign == -1 ? -ans : ans;
    }

    private int div(int a, int b) {
        if (a > b) {
            return 0;
        }
        int count = 1;
        int tb = b;
        while (tb + tb >= a && tb + tb < 0) {
            tb = tb <<1;
            count += count;
        }
        return count + div(a - tb, b);
    }
}
