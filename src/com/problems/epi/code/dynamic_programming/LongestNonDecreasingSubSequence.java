package com.problems.epi.code.dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class LongestNonDecreasingSubSequence {

    public static int longestNonDecreasingSubsequenceLength(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return -1;
        int[][] table = new int[nums.size()][nums.size() + 1];
        for(int[] row : table) Arrays.fill(row, -1);
        return longestNonDecreasingSubsequenceLength_TopDown(nums, nums.size() - 1, nums.size(), table);
        // return longestNonDecreasingSubsequenceLength_Recursive(nums, nums.size() - 1, nums.size());
    }

    private static int longestNonDecreasingSubsequenceLength_Recursive(List<Integer> nums, int i, int j) {
        if(i < 0) return 0;
        int taken = 0;
        if(j == nums.size() || nums.get(j) >= nums.get(i)) {
            taken = 1 + longestNonDecreasingSubsequenceLength_Recursive(nums, i - 1, i);
        }
        int nottaken = longestNonDecreasingSubsequenceLength_Recursive(nums, i - 1, j);
        return Math.max(taken, nottaken);
    }

    private static int longestNonDecreasingSubsequenceLength_TopDown(List<Integer> nums, int i, int j, int[][] table) {
        if(i < 0) return 0;
        if(table[i][j] == -1) {
            int taken = 0;
            if(j == nums.size() || nums.get(j) >= nums.get(i)) {
                taken = 1 + longestNonDecreasingSubsequenceLength_TopDown(nums, i - 1, i, table);
            }
            int nottaken = longestNonDecreasingSubsequenceLength_TopDown(nums, i - 1, j, table);
            table[i][j] = Math.max(taken, nottaken);
        }
        return table[i][j];
    }

    private static int longestNonDecreasingSubsequenceLength_BottomUp1D(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) return -1;
        int[] table = new int[nums.size()];
        Arrays.fill(table, 1);
        int result = Integer.MIN_VALUE;
        for(int i = 1; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(nums.get(j) <= nums.get(i)) {
                    table[i] = Math.max(table[i], table[j] + 1);
                    result = Math.max(result, table[i]);
                }
            }
        }
        return result;
    }
    private static void initTable(int[][] table) {
        for(int i = 0; i < table[0].length; i++) {
            table[0][i] = 1;
        }
    }
}
