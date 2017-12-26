package com.problems.leetcode.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums, write a method that
 * returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of
 * the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 */
public class FindPivotIndex {

    /**
     * This is the optimal solution.
     * Key Insight: Find a quick way to compute the leftSum and rightSum at every index of the array
     * First find the total sum of all elements and then use Prefix Sum (sum of values ranging from  0 to i)
     * Hence, leftSUm = prefixSum while rightSum = sum - leftSum - nums[i]
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findPivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int leftSum = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        for(int j = 0; j < nums.length; j++) {
            if(sum - leftSum - nums[j] == leftSum) return j;
            leftSum += nums[j];
        }
        return -1;
    }

    /**
     * This is the brute force solution.
     * Key Insight: Find a way to compute the leftSum and rightSum at every index of the array
     * The outer loop maintains the leftSUm while the inner loop maintains the rightSum
     * At the end of the inner loop, check if the condition (leftSum == rightSum) is satisfied
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int findPivotIndexBruteForce(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
            rightSum = 0;
        }
        return -1;
    }
}
