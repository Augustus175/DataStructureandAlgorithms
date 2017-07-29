package com.dsa.mydsa.Test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by zhangzhibo on 2017/5/5.
 */
public class Birthday {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int a = (int)Math.pow(365,n);
        int b = factorial(10);
        System.out.println(b);

    }
    public static int  factorial(int n)
    {
        if (n==0)
        {
            return 1;
        }else{
           return  n*(factorial(n-1));
        }
    }
}
