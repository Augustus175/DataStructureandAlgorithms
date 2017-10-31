package com.dsa.mydsa.leetcode;

import javax.sound.midi.Soundbank;

public class No28_ImplementstrStr {
    public static void main(String[] args) {
        String r = "AB";
        String s = "AB";
        System.out.println(strStr(s, r));
        System.out.println(s.indexOf(r));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] p = needle.toCharArray();
        char[] s = haystack.toCharArray();
        int[] next = new int[p.length];
        GetNext(p, next);
        int j = 0;
        int i = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void GetNext(char[] p, int[] next) {
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }
}
