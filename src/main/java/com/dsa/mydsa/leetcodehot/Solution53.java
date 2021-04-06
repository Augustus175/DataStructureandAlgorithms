package com.dsa.mydsa.leetcodehot;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int current = result;
        for (int i = 0; i < nums.length; i++) {
            if (current < 0) {
                current = nums[i];
            } else {
                current += nums[i];
            }
            result = Math.max(current, result);
        }
        return result;
    }

}
