package com.dsa.mydsa.chap06;

import java.util.Scanner;

/**
 * Created by zhangzhibo on 17-3-23.
 */
public class AngramApp {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) {
        System.out.println("Enter a word :");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        size = input.length();
        count = 0;
        arrChar = input.toCharArray();
        doAnagram(size);
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                displayWord();
            }
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char tmp = arrChar[position];
        for (j = position +1; j < size ; j++) {
            arrChar[j-1] = arrChar[j];
        }
        arrChar[j-1] = tmp;
//        for(char c : arrChar)
//        {
//            System.out.print(c);
//        }
//        System.out.println();
    }

    public static void displayWord() {
        if (count < 99)
        {
            System.out.print(" ");
        }
        if (count < 9)
        {
            System.out.print(" ");
        }
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(arrChar[i]);
        }
        System.out.print("    ");
        System.out.flush();
        if (count%6 ==0)
        {
            System.out.println();
        }
    }
}
