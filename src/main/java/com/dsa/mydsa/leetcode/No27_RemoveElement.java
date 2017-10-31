package com.dsa.mydsa.leetcode;

public class No27_RemoveElement {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int leftptr = -1;
        int rightptr = right + 1;
        while (leftptr < rightptr) {
            while (++leftptr <= right && nums[leftptr] != val) ;
            while (--rightptr >= left && nums[rightptr] == val) ;
            swap(nums, leftptr, rightptr);
        }
        return leftptr + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
