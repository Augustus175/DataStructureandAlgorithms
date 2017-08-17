package com.dsa.mydsa.chap02b;

/**
 * Created by zhangzhibo on 17-5-25.
 */
public class ModeApp {
    public static void main(String[] args) {
//        int[] a = {3, 1, 1, 1, 2, 1, 5, 5, 1, 3, 2,};
//        int[] a = {1,2,3,2,4,2,5,2,3};
        int[] a = {8, 8, 1, 1, 1, 8, 1, 1, 6, 1, 8};
        int m = mode(a);
        System.out.println(m);
    }

    public static int mode(int[] a) {
        int m = a[0];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                m = a[i];
                count = 1;
            } else if (m != a[i]) {
                count--;
            } else {
                count++;
            }
        }
        return m;

    }
}
