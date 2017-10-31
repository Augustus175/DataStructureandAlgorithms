package com.dsa.mydsa.leetcode;

public class No26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] a = {1,1,1,3};
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        int i = 0;
        for (int j = i+1; j < nums.length; j++) {
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

}
