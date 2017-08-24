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
            System.out.print(i + " ");
        }
        System.out.println();
        reOrderArray1(arr);
        for (int i :
                arr) {
            System.out.print(i + " ");
        }
    }

    /**
     *  * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     *  * 2.i从左向右遍历，找到第一个偶数。
     *  * 3.j从i+1开始向后找，直到找到第一个奇数。
     *  * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     *  * 5.終止條件：j向後遍歷查找失敗。
     *  
     */
    public void reOrderArray(int[] a) {
        if (a == null || a.length == 0)
            return;
        int i = 0, j;
        while (i < a.length) {
            while (i < a.length && !isEven(a[i]))
                i++;
            j = i + 1;
            while (j < a.length && isEven(a[j]))
                j++;
            if (j < a.length) {
                int tmp = a[j];
                for (int k = j - 1; k >= i; k--) {
                    a[k + 1] = a[k];
                }
                a[i++] = tmp;
            } else {// 查找失敗
                break;
            }
        }
    }

    public boolean isEven(int n) {
        if (n % 2 == 0) return true;
        return false;
    }

    public static void reOrderArray1(int[] array) {
        int left = -1;
        int right = array.length;
        while (true) {
            while ((++left < array.length) && array[left] % 2 == 1) ;
            while ((--right >= 0) && array[right] % 2 == 0) ;
            if (left >= right) {
                break;
            } else {
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
