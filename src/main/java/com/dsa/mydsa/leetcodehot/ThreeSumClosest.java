package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int t = 0;
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = length - 1;
                while (k > j && (nums[i] + nums[j] + nums[k] > target)) {
                    t = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                    if (min > t) {
                        min = t;
                        result = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }
                if (k == j) {
                    break;
                }
                t = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                if (min > t) {
                    min = t;
                    result = nums[i] + nums[j] + nums[k];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        threeSumClosest.threeSumClosest(nums, target);

    }
}
