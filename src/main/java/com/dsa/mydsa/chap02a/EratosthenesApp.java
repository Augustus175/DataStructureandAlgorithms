package com.dsa.mydsa.chap02a;

/**
 * Created by zhangzhibo on 17-5-21.
 */
public class EratosthenesApp {
    public static void main(String[] args) {
        boolean[] num = new boolean[100];
        Eratosthene(num);
        for (int i = 0; i < num.length; i++) {
            if (!num[i]) {
                System.out.println(i);
            }
        }

    }

    public static void Eratosthene(boolean[] a) {
        a[0] = true;
        a[1] = true;
        int p = 2;
        int j = p * p;
        while (j < a.length) {
            while (j < a.length) {
                a[j] = true;
                j += p;
            }
            p++;
            while (a[p]) {
                p++;
            }
            j = p * p;
        }
    }
}
