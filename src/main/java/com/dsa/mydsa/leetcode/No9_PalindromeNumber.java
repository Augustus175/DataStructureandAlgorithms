package com.dsa.mydsa.leetcode;

public class No9_PalindromeNumber {
    public static void main(String[] args) {

    }

    //  基本思想是就是把回文数折成两半，如12344321折成1234 和1234然后进行比较如果相等就是回文数
    //  但是如果有这种情况12321，同样的折成了两半x=12和rev= 123，这时候将rev/10后比较
    //  开头为了判断负数和以0为结尾的数字，例如10，100等肯定不是回文数
    public boolean isParlindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (rev == x || (rev / 10) == x);
    }
}
