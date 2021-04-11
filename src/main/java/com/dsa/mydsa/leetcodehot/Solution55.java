package com.dsa.mydsa.leetcodehot;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }

    public boolean canJump(int[] nums, int t) {
        int reach = 0;
        for (int i = 0; i <= reach && reach < nums.length - 1; i++) {
            reach = Math.max(i + nums[i], reach);
        }
        return reach >= nums.length - 1;
    }
}
