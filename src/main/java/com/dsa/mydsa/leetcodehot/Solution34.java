package com.dsa.mydsa.leetcodehot;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int startIdx = findFirstIndex(nums, target);
        if (startIdx == -1) {
            return new int[]{-1, -1};
        }
        int endIdx = findLastIndex(nums, target);
        return new int[]{startIdx, endIdx};
    }

    private int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
//                fist 和 last 区别就在这里
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    private int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right + 1) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
//                fist 和 last 区别就在这里
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
