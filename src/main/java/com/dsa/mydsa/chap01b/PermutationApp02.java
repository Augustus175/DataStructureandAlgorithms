package com.dsa.mydsa.chap01b;

import java.util.Scanner;

/**
 * Created by zhangzhibo on 2017/5/8.
 */
public class PermutationApp02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] strchar = str.toCharArray();
        Permutation(strchar, str.length(), 0);
    }

    public static void Permutation(char[] a, int size, int start) {
        if (start == size - 1) {
            String str = new String(a);
            System.out.println(str);
        }
        for (int i = start; i < size; i++) {
            if (!isDuplicate(a,start,i))
            {
                continue;
            }
            swap(a, i, start);
            Permutation(a, size, start + 1);
            swap(a, i, start);
        }

    }

    public static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean isDuplicate(char[] a, int n, int t) {
        while (n < t) {
            if (a[n]==a[t])
            {
                return false;
            }
            n++;
        }
        return true;
    }
}
