package com.dsa.mydsa.leetcodehot;

public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                return ans;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = 123;
        x = -123;
        int reverse = reverseInteger.reverse(x);
        System.out.println(reverse);
    }
}
