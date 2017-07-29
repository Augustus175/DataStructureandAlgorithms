package com.dsa.mydsa.chap02b;

import java.util.Arrays;

/**
 * Created by zhangzhibo on 17-5-27.
 */
public class CantorApp {
    public static void main(String[] args) {
        int[] a = {3,4,1,2,1,0};
        Cantor(a);
        for (int k :
                a) {
            System.out.print(k+" ");
        }
    }

    public static void Cantor(int[] a) {
        int[] sa = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sa[i] = i+1;
            System.out.print(sa[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
//           when use the tmp the n in the deleEle function do not need to sub 1
//           int tmp = a[i];
            a[i] = sa[a[i]];
//            deleEle(sa,tmp);
            deleEle(sa,a[i]);
        }

    }

    public static void deleEle(int[] a,int n) {
//        when use another space tmp, n do not need sub 1
//        for (int i = n; i <a.length-1 ; i++) {
        for (int i = n-1; i <a.length-1 ; i++) {
            a[i] = a[i+1];
        }
    }
}
