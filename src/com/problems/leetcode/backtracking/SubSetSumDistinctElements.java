package com.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode #39
 * 	Notes:
 * 	All numbers (including target) will be positive integers.
 * 	The solution set must not contain duplicate combinations.
 */
public class SubSetSumDistinctElements {

    public static List<List<Integer>> findSubsetSum(int[] nums, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        findSubsetSum(nums, 0, sum, new ArrayList<>(), result);
        return result;
    }

    private static void findSubsetSum(int[] nums, int idx, int sum, List<Integer> tmp, List<List<Integer>> result) {
        if (sum < 0) return;
        if (sum == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            findSubsetSum(nums, i,sum - nums[i], tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> result = findSubsetSum(new int[]{10,1,2,7,6,1,5}, 8);
        List<List<Integer>> result = findSubsetSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> set : result) {
            System.out.print(Arrays.toString(set.toArray()));
            System.out.println();
        }
    }
}
