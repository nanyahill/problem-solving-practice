package com.problems.classic_problems.dynamic_programming;

import java.util.Arrays;
import java.util.List;

// This can be used to solve longest non-decreasing subsequence
public class LongestIncreasingSubsequence {

    /******************* Recursive Approach Time: O(n2^n), Space: O(n) **************************
     ***********************************************************************************************/

    /**
     * Recursive starting from the back of array
     */
    public int longestIncreasingSubSequence_Recursive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return longestIncreasingSubSequence_Recursive(nums, Integer.MAX_VALUE, nums.length - 1);
    }

    public int longestIncreasingSubSequence_Recursive(int[] nums, int next, int idx) {
        if (idx < 0) {
            return 0;
        }
        int taken = 0;
        if (nums[idx] < next) {
            taken = 1 + longestIncreasingSubSequence_Recursive(nums, nums[idx], idx - 1);
        }
        int nottaken = longestIncreasingSubSequence_Recursive(nums, next, idx - 1);
        return Math.max(taken, nottaken);
    }

    /** Recursive starting from the front of array */
//    public int longestIncreasingSubSequence_Recursive(int[] nums) {
//        return longestIncreasingSubSequence_Recursive(nums, Integer.MIN_VALUE, 0);
//    }
//
//    public int longestIncreasingSubSequence_Recursive(int[] nums, int prev, int idx) {
//        if (idx == nums.length) {
//            return 0;
//        }
//        int taken = 0;
//        if (nums[idx] > prev) {
//            taken = 1 + longestIncreasingSubSequence_Recursive(nums, nums[idx], idx + 1);
//        }
//        int nottaken = longestIncreasingSubSequence_Recursive(nums, prev, idx + 1);
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

    public int longestIncreasingSubSequence_TopDown(int[] nums, int next, int idx, int[][] cache) {
        if (idx < 0) {
            return 0;
        }
        if (cache[next][idx] != -1) return cache[next][idx];
        int taken = 0;
        if (next == nums.length || nums[idx] < nums[next]) {
            taken = 1 + longestIncreasingSubSequence_TopDown(nums, idx, idx - 1, cache);
        }
        int nottaken = longestIncreasingSubSequence_TopDown(nums, next, idx - 1, cache);
        cache[next][idx] = Math.max(taken, nottaken);
        return cache[next][idx];
    }

    /******************* Bottom Up DP Approach Time: O(n^2), Space: O(n) **************************
     **********************************************************************************************/
    public static int longestIncreasingSubSequence_BottomUp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 1; // 1 since if nums.length > 0 then least value of LIS is 1.
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) { // >= to allow duplicates
                    cache[i] = Math.max(cache[j] + 1, cache[i]); // hold LIS from j to i - 1
                }
            }
            result = Math.max(result, cache[i]); // prevents an extra iteration of cache to find the result
        }
        return result;
    }

    public static int longestIncreasingSubsequence_NLogN(List<Integer> nums) {
        if (nums == null || nums.size() == 0) return 0;
        int[] cache = new int[nums.size()];
        int len = 0;
        for (int num : nums) {
            int j = Arrays.binarySearch(cache, 0, len, num);
            if (j < 0)
                j = -(j + 1); // get real insertion point back where  value returned is (-(real insertion point) - 1) back
            cache[j] = num;
            if (len == j) len++;
        }
        return len;
    }

    public static int longestNonDecreasingSubsequence_NLogN(List<Integer> nums) {
        int[] cache = new int[nums.size()];
        int len = 0;
        for (int num : nums) {
            int j = binarySearch(cache, 0, len - 1, num);
            cache[j] = num;
            if (len == j) len++;
        }
        return len;
    }

    private static int binarySearch(int[] nums, int lo, int hi, int num) {
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] <= num) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        //System.out.print(lengthOfLIS(nums));
        //System.out.println(Arrays.binarySearch(new int[]{10}, 0, 1, 11));
        System.out.println(-0);

    }
}
