package com.dsa.mydsa.leetcodehot;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNmae Solution29
 * @Description TODO
 * @Author admin
 * @DATE 2021-1-18 10:03
 * @Version
 **/
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<int[]> freq = new ArrayList<>();
        Arrays.sort(candidates);
        int size = 0;
        for (int num :
                candidates) {
            size = freq.size();
            if (freq.isEmpty() || (freq.get(size - 1)[0] != num)) {
                freq.add(new int[]{num, 1});
            } else {
                freq.get(size - 1)[1]++;
            }
        }
        dfs(0, target, freq, result, tmp);
        return result;
    }

    private void dfs(int pos, int target, List<int[]> freq, List<List<Integer>> result, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        if (pos >= freq.size()) {
            return;
        }
        dfs(pos + 1, target, freq, result, tmp);
        int min = Math.min((freq.get(pos)[0]), freq.get(pos)[1]);
        for (int i = 1; i <= min; i++) {
            tmp.add(freq.get(pos)[0]);
            dfs(pos + 1, target - i * freq.get(pos)[0], freq, result, tmp);
        }
        for (int i = 1; i <= min; i++) {
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] nums = new int[]{1,2,3,4};
        int target = 6;
        solution40.combinationSum2(nums,target);
    }
}

