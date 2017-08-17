package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-21.
 */
public class No09 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci2(10));
        System.out.println(FibonacciTail(11, 0, 1));
        double t1 = 1.2;
        double t2 = 1.2;
        System.out.println(t1==t2);
    }

    //1650ms
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //12ms    tail
    public static int FibonacciTail(int n, int acc1, int acc2) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return acc1;
        }
        return FibonacciTail(n - 1, acc2, acc1 + acc2);
    }
    //12ms
    public static int Fibonacci2(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
