package com.dsa.mydsa.OctoberAlgorithms.chap01b;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-8-12.
 */
public class AssociationTest {
    public static void main(String[] args) {
        int[] num = new int[] { 1, 2, 3, 4, 5 };
        String str = "";
        // 求3个数的组合个数
        count(0, str, num, 3);
        // 求1-n个数的组合个数
        for (String s:reslt) {
            System.out.println(s);
        }
//        countAll(0, str, num);
    }

    public static void countAll(int i, String str, int[] num) {
        if (i == num.length) {
            System.out.println(str);
            return;
        }
        countAll(i + 1, str, num);
        countAll(i + 1, str + num[i] + ",", num);
    }

    public  static ArrayList<String> reslt = new ArrayList<>();
    public static void count(int i, String str, int[] num, int n) {
        if (n == 0) {
//            System.out.println(str);
            reslt.add(str);
            return;
        }
        if (i == num.length) {
            return;
        }
        count(i + 1, str + num[i] + ",", num, n - 1);
        count(i + 1, str, num, n);
    }
}
