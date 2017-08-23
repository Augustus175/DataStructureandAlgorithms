package com.dsa.mydsa.OctoberAlgorithms.chap02b;

/**
 * Created by zhangzhibo on 17-5-27.
 */
public class HollandApp {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 0, 1, 2, 1, 1, 0, 0, 0};
//        Holland(a);
        LastHolland(a);
        for (int k :
                a) {
            System.out.print(k + " ");
        }
    }

    public static void Holland(int[] a) {
        int begin = 0;
        int cur = 0;
        int end = a.length - 1;
        int count = 0;
        while (cur <= end) {
            count++;
            if (a[cur] == 2) {
                swap(a, cur, end);
                end--;
            } else if (a[cur] == 1) {
                cur++;
            } else if (cur == begin) {
                cur++;
                begin++;
            } else {
                swap(a, cur, begin);
                begin++;
//                if cur did not add 1,the program is also right ,but if cur add 1, the situation is more better
                cur++;
            }
        }
        System.out.println(count);

    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void LastHolland(int[] a) {
        int begin = 0;
        int cur = 0;
        int end = a.length - 1;
        int count = 0;
        while (cur <= end) {
            count++;
            if (a[cur] == 2) {
                swap(a, cur, end);
                end--;
            } else if (a[cur] == 1) {
                cur++;
            } else {
                if (cur == begin) {
                    swap(a, cur, begin);
                }
                begin++;
//                if cur did not add 1,the program is also right ,but if cur add 1, the situation is more better
                cur++;
            }
        }
        System.out.println(count);

    }

}
