package com.problems.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /******************* Bottom Up DP Approach Time: O(n2^n), Space: O(n) **************************
     ***********************************************************************************************/

    /** Recursive starting from the back of array */
    public int longestIncreasingSubSequence_Recursive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return longestIncreasingSubSequence_Recursive(nums, Integer.MAX_VALUE, nums.length - 1);
    }

    public int longestIncreasingSubSequence_Recursive(int[] nums, int next, int curpos) {
        if (curpos < 0) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] < next) {
            taken = 1 + longestIncreasingSubSequence_Recursive(nums, nums[curpos], curpos - 1);
        }
        int nottaken = longestIncreasingSubSequence_Recursive(nums, next, curpos - 1);
        return Math.max(taken, nottaken);
    }

    /** Recursive starting from the front of array */
//    public int longestIncreasingSubSequence_Recursive(int[] nums) {
//        return longestIncreasingSubSequence_Recursive(nums, Integer.MIN_VALUE, 0);
//    }
//
//    public int longestIncreasingSubSequence_Recursive(int[] nums, int prev, int curpos) {
//        if (curpos == nums.length) {
//            return 0;
//        }
//        int taken = 0;
//        if (nums[curpos] > prev) {
//            taken = 1 + longestIncreasingSubSequence_Recursive(nums, nums[curpos], curpos + 1);
//        }
//        int nottaken = longestIncreasingSubSequence_Recursive(nums, prev, curpos + 1);
//        return Math.max(taken, nottaken);
//    }

    /******************* Top Down DP Approach Time: O(n^2), Space: O(n^2) **************************
     ***********************************************************************************************/
    public int longestIncreasingSubSequence_TopDown(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] cache = new int[nums.length + 1][nums.length];
        for (int[] row : cache) Arrays.fill(row, -1);
        return longestIncreasingSubSequence_TopDown(nums, nums.length, nums.length - 1, cache);
    }

    public int longestIncreasingSubSequence_TopDown(int[] nums, int next, int curpos, int[][] cache) {
        if (curpos < 0) {
            return 0;
        }
        if (cache[next][curpos] != -1) return cache[next][curpos];
        int taken = 0;
        if (next == nums.length || nums[curpos] < nums[next]) {
            taken = 1 + longestIncreasingSubSequence_TopDown(nums, curpos, curpos - 1, cache);
        }
        int nottaken = longestIncreasingSubSequence_TopDown(nums, next, curpos - 1, cache);
        cache[next][curpos] = Math.max(taken, nottaken);
        return cache[next][curpos];
    }

    /******************* Bottom Up DP Approach Time: O(n^2), Space: O(n) **************************
     **********************************************************************************************/
    public int longestIncreasingSubSequence_BottomUp(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int[] cache = new int[nums.length];
        cache[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int taken = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    taken = Math.max(cache[j], taken);
                }
            }
            cache[i] = taken + 1;
            res = Math.max(res, cache[i]);
        }
        return res;
    }
}
