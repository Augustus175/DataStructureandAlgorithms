package com.dsa.mydsa.leetcode;

public class No7_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(1));
    }

    public static int reverse(int x) {
        int result = 0;
        int tmpresult = 0;
        int tail = 0;
        while (x != 0) {
            tail = x % 10;
            tmpresult = (x % 10) + tmpresult * 10;
            if((tmpresult-tail)/10!=result){
                return 0;
            }
            x = x / 10;
            result = tmpresult;
        }
        return result;
    }
}
