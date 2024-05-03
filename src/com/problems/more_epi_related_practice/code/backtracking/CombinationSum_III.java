package com.problems.more_epi_related_practice.code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/">...</a>
 */
public class CombinationSum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 0)
            return result;
        boolean[] used = new boolean[10];
        helper(k, n, 1, result, new ArrayList<>(), used);
        return result;
    }

    private void helper(int k, int target, int start, List<List<Integer>> result, List<Integer> tmp,
                        boolean[] used) {
        if (target == 0 && tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (used[i])
                continue;
            int num = i;
            if (tmp.size() < k && num <= target) {
                tmp.add(num);
                used[i] = true;
                helper(k, target - num, i, result, tmp, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}
