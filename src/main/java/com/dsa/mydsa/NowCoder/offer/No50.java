package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-4.
 */
public class No50 {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(100));
    }

    public  static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))!=0);
        return sum;
    }
}
