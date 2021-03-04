package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        recu(result, tmp, candidates, target, 0);
        return result;
    }

    private void recu(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        recu(result, tmp, candidates, target, idx + 1);
        if (target >= candidates[idx]) {
            tmp.add(candidates[idx]);
            recu(result, tmp, candidates, target - candidates[idx], idx);
            tmp.remove(tmp.size() - 1);
        }
    }
}
