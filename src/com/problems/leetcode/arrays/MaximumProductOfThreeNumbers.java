package com.problems.leetcode.arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 */
public class MaximumProductOfThreeNumbers {

    /**
     * This is the optimal solution.
     * Key Insight: Maximum product of three numbers can be found by
     * finding the product of the first three max numbers, however, the array can take -ve numbers
     * Hence the maximum product can also be the product of the first two minimum numbers and the maximum number.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findMaximumProductOfThreeNumbers(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            }
            else if(nums[i] < secondMin) {
                secondMin = nums[i];
            }
            if(nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else if(nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
    }

    /**
     * This is the brute force solution.
     * Key Insight: Enumerate all possible combination of any three numbers in the array
     * Check their product and find the maximum between them
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static int findMaximumProductOfThreeNumbersBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = i + 2; k < nums.length; k++) {
                    max = Math.max(max, nums[i] * nums[j]* nums[k]);
                }
            }
        }
        return max;
    }
}
