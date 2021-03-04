package com.dsa.mydsa.leetcodehot;

public class QuickSort {
    public void qSort(int[] nums, int start, int end) {
        if (start < end) {
            int partition = partition(nums, start, end);
            qSort(nums, start, partition - 1);
            qSort(nums, partition + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left != right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, start, left);
        return left;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{4, 1, 3, 6, 3, 8, 2, 9, 1, 0, 5, 3};
        nums = new int[]{3, 2, 1};
        quickSort.qSort(nums, 0, nums.length - 1);
        for (int i :
                nums) {
            System.out.println(i);
        }

    }
}
