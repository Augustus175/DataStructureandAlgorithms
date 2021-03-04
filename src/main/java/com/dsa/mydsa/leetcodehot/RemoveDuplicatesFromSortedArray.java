package com.dsa.mydsa.leetcodehot;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                if (i + 1 == j) {
                    i++;
                    j++;
                } else {
                    nums[i + 1] = nums[j];
                    i++;
                    j++;
                }
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,2};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        removeDuplicatesFromSortedArray.removeDuplicates(num);
    }
}
