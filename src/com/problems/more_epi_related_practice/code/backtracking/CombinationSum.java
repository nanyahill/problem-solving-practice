package com.problems.more_epi_related_practice.code.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">...</a>
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num <= target) {
                tmp.add(num);
                helper(candidates, target - num, i, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
