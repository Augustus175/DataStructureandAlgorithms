package com.dsa.mydsa.leetcodehot;

import java.util.*;

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        int depth = 0;
        Arrays.sort(nums);
        dfs(nums, len, depth, used, result, stack);
        return result;

    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, List<List<Integer>> result, Deque<Integer> stack) {
        if (len == depth) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
//            前一个没用过，当前的和前一个相同，那么当前也不能用
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i-1])) {
                continue;
            }
            stack.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, result, stack);
            stack.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{0,1, 1};
        Solution47 solution47 = new Solution47();
        List<List<Integer>> lists = solution47.permuteUnique(num);
        System.out.println(lists);
    }
}
