package com.problems.more_epi_related_practice.code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(nums, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
