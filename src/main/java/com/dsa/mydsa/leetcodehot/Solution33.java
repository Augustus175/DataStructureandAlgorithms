package com.dsa.mydsa.leetcodehot;

public class Solution33 {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int r = nums.length - 1;
        int n = nums.length - 1;
        int l = 0;
        int mid;
        while (l <= r) {
            mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[0]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
