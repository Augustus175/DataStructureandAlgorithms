package com.dsa.mydsa.myutil;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhangzhibo-dell on 17-8-22.
 */
public class Sunselect {
    public static void main(String[] args) {
        Random ran = new Random(23);
        int[] a = new int[6];
        for (int i = 0; i < a.length; i++) {
            a[i] = ran.nextInt(10);
        }
        ArrayList<String> result = new ArrayList<>();
        result = select(a, 2, result);
        for (String s :
                result) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> select(int[] a, int k, ArrayList<String> result) {
        int[] tmp = new int[k];
        return subselect(a, 0, 1, tmp, k, result);
    }

    private static ArrayList<String> subselect(int[] a, int head, int index, int[] r, int k, ArrayList<String> result) {
        for (int i = head; i < a.length + index - k; i++) {
            if (index < k) {
                r[index - 1] = a[i];
                subselect(a, i + 1, index + 1, r, k, result);
            } else if (index == k) {
                r[index - 1] = a[i];
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < r.length; j++) {
                    sb.append(r[j]);
                    sb.append(" ");
                }
                result.add(sb.toString().trim());
                subselect(a, i + 1, index + 1, r, k, result);
            } else {
                return result;
            }
        }
        return result;
    }
}
