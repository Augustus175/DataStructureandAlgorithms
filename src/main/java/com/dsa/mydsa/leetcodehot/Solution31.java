package com.dsa.mydsa.leetcodehot;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;

        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i >= 0) {
            for (int l = nums.length - 1; l > i; l--) {
                if (nums[l] > nums[i]) {
                    swap(nums, i, l);
                    break;
                }
            }
        }
        qSort(nums, i + 1, nums.length - 1);


    }

    private void qSort(int[] nums, int start, int end) {
        if (start < end) {
            int partition = partition(nums, start, end);
            qSort(nums, start, partition - 1);
            qSort(nums, partition + 1, end);
        }
    }

    private int partition(int[] num, int start, int end) {
        int pivot = num[start];
        int left = start;
        int right = end;
        while (left != right) {
            while (left < right && num[right] > pivot) {
                right--;
            }
            while (left < right && num[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(num, left, right);
            }
        }
        swap(num, left, start);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        nums = new int[]{1, 1, 5};
        nums = new int[]{1};
        nums = new int[]{3, 2, 1};
//        nums = new int[]{2, 3, 1};
//        nums = new int[]{4, 2, 0, 2, 3, 2, 0};
        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(nums);
        for (int i :
                nums) {
            System.out.println(i);
        }
    }

}
