package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int p = 0; p < length - 4; p++) {
            if (p > 0 && nums[p] == nums[p - 1]) {
                continue;
            }

            int target_p = target - nums[p];
            for (int i = p + 1; i < length - 3; i++) {
                if (i > p + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int k = length - 1;
                    while (k > j && (nums[i] + nums[j] + nums[k] > target_p)) {
                        k--;
                    }
                    if (k == j) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[k] == target_p) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[p]);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        result.add(tmp);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
//        nums = new int[]{0, 0, 0, 0};
//        nums = new int[]{-2, -1, -1, 1, 1, 2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum.fourSum(nums, target);
        System.out.println(lists);
    }
}
