package com.dsa.mydsa.chap01b;

import java.util.Scanner;

/**
 * Created by zhangzhibo on 2017/5/3.
 */
public class StringRoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] strchar = str.toCharArray();
        leftRotateString(strchar,4,strchar.length);
        String result = new String(strchar);
        System.out.println(result);
    }

    public static void leftRotateString(char[] strchar, int m, int n) {
        m %= n;
        roll(strchar,0,m-1);
        roll(strchar,m,n-1);
        roll(strchar,0,n-1);


    }

    public static void roll(char[] strchar, int from, int to) {
        while (from < to) {
            char tmp = strchar[from];
            strchar[from++] = strchar[to];
            strchar[to--] = tmp;
        }


    }
}
