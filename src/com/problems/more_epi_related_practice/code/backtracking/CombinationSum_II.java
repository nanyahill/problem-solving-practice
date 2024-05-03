package com.problems.more_epi_related_practice.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        helper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            int num = candidates[i];
            if (num <= target) {
                tmp.add(num);
                helper(candidates, target - num, i + 1, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
