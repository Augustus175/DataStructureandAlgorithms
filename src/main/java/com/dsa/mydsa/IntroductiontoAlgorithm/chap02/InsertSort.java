package com.dsa.mydsa.IntroductiontoAlgorithm.chap02;

import com.dsa.mydsa.NowCoder.offer.RandomArray;

import java.util.Arrays;

/**
 * Created by zhangzhibo-dell on 17-8-26.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = RandomArray.getArrag(10);
        int[] flag = new int[arr.length];
        int i = 0;
        for (int k :
                arr) {
           flag[i++] = k;
            System.out.print(k+" ");
        }
        insertsort(arr);
        Arrays.sort(flag);
        System.out.println();
        for (int k :
                arr) {
            System.out.print(k+" ");
        }
        System.out.println();
        for (int k :
                flag) {
            System.out.print(k+" ");
        }
    }
    public static void insertsort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0&&key<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
