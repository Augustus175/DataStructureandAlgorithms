package com.dsa.mydsa.leetcodehot;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int depth = 0;
        boolean[] used = new boolean[len];
        dfs(nums, len, depth, used, stack, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> stack, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                stack.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, used, stack, result);
                stack.removeLast();
                used[i] = false;
            }
        }
    }
}
