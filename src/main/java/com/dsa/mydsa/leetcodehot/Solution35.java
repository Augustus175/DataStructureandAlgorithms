package com.dsa.mydsa.leetcodehot;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        return binarySearch(nums, target);

    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int mid;
        int right = nums.length - 1;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
