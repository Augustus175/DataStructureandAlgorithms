package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class inttext {
    public static void main(String[] args) {
    String str = "abcd";
    char[] chars = str.toCharArray();
    docore(chars,0);
        for (String s :
                result) {
            System.out.println(s);
        }

    }

    public static ArrayList<String> result = new ArrayList<>();

    public static void docore(char[] a, int start) {
        if (start >= a.length) {
            result.add(new String(a));
            return;
        }
        for (int i = start; i < a.length; i++) {
            if (isDuplation(a, start, i)) {
                continue;
            }
            swap(a, start, i);
            docore(a, start + 1);
            swap(a, start, i);
        }
    }

    public static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static boolean isDuplation(char[] a, int start, int end) {
        for (int i = start; i < end; i++) {
            if (a[start] == a[end]) {
                return true;
            }
        }
        return false;
    }

}


