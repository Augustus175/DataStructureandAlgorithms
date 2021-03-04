package com.dsa.mydsa.leetcodehot;

public class BinarySearch {
    public int search(int[] nums, int target, int left, int right) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println(mid);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1, 4, 5, 6, 8, 12, 29};
        int target = 1;
        int result = binarySearch.search(nums, target, 0, nums.length - 1);
        System.out.println(result);
    }


}
