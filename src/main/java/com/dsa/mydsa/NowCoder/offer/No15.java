package com.dsa.mydsa.NowCoder.offer;

import java.util.Stack;

/**
 * Created by zhangzhibo on 17-6-23.
 */
public class No15 {
    public static void main(String[] args) {
        int[] arr = RandomArray.getArrag(16);
//        int[] arr = {9,2,0,3,6,7};
        for (int i :
                arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        reOrderArray1(arr);
        for (int i :
                arr) {
            System.out.print(i+" ");
        }
    }

    public static void reOrderArray(int[] array) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                stack2.push(array[i]);
            } else {
                stack1.push(array[i]);
            }
        }
        int k = array.length - 1;
        while (!stack2.empty()) {
            array[k] = stack2.pop();
            k--;
        }
        while (!stack1.empty()) {
            array[k] = stack1.pop();
            k--;
        }
    }

    public static void reOrderArray1(int[] array) {
        int left = -1;
        int right = array.length;
        while (true) {
            while ((++left < array.length) && array[left] % 2 == 1) ;
            while ((--right >= 0) && array[right] % 2 == 0) ;
            if (left >= right) {
                break;
            }else {
                swap(array, left, right);
            }
        }
    }

    public static void swap(int[] a, int l, int r) {
        int tmp = a[r];
        a[r] = a[l];
        a[l] = tmp;
    }
}
