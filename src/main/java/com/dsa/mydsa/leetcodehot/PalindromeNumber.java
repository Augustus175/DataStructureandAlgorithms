package com.dsa.mydsa.leetcodehot;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int tmp = 0;
        while ((tmp < x)) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        if ((tmp == x) || (tmp / 10 == x)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 123;
        boolean palindrome = palindromeNumber.isPalindrome(x);
        System.out.println(palindrome);

    }
}
