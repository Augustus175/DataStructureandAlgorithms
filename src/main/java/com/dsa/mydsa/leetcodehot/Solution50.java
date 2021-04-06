package com.dsa.mydsa.leetcodehot;

public class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPowHelper(x, Math.abs(n));
        }
        return myPowHelper(x, n);

    }

    private double myPowHelper(double x, int n) {
        if (n == 1) {
            return x;
        }
        double half = myPowHelper(x, n / 2);
        if (n % 2 != 0) {
            return x * half * half;
        } else {
            return half * half;
        }
    }
}
