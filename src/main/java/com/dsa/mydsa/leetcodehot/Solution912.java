package com.dsa.mydsa.leetcodehot;

public class Solution912 {
    public int[] sortArray(int[] nums) {

        return nums;
    }

    public int[] merge(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                result[k++] = num1[i++];
            } else {
                result[k++] = num2[j++];
            }
        }
        while (i < num1.length) {
            result[k++] = num1[i++];
        }
        while (j < num2.length) {
            result[k++] = num2[j++];
        }
        return result;
    }

    public void merge(int[] num, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (num[i] < num[j]) {
                tmp[k++] = num[i++];
            } else {
                tmp[k++] = num[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = num[i++];
        }
        while (j <= right) {
            tmp[k++] = num[j++];
        }
        while (left <= right) {
            num[left++] = tmp[k++];
        }

    }

}
