package com.problems.more_epi_related_practice.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {
    public List<List<Integer>> subsetsWithDup(int[] candidates) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        Arrays.sort(candidates);
        helper(candidates, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int start, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            int num = candidates[i];
            tmp.add(num);
            helper(candidates, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
