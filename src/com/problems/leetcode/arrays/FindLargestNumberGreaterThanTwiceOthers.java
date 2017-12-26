package com.problems.leetcode.arrays;

/**
 * Question: In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 */
public class FindLargestNumberGreaterThanTwiceOthers {

    /**
     * Key Insight: How do you test if a number is larger than twice another number?
     * Be careful if division is your method- largerNo / AnotherNo;
     * you may run into the arithmetic exception for divide by 0
     * Solution: The maximum number in array needs to be greater than
     * twice every other number in the array
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;

        int maxIdx = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[maxIdx]) maxIdx = i;
        }
        for(int j = 0; j < nums.length; j++) {
            if(j != maxIdx && nums[maxIdx] <  (2 * nums[j])) return -1;
        }
        return maxIdx;
    }

    /**
     * This solution iterates the array only once based on the below key insight
     * Key Insight: The largest number in the array must be greater than or equal twice the
     * second largest number in the array. If this is not true, then we can conclude that the
     * largest number in the array will never be greater than or equal to any other element in the array
     * Time Complexity: O(n)
     * Space complexity: O(1)
     */
    public static int dominantIndexAnotherSolution(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int firstMax = 0, secondMax = 0, idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                idx = i;
            }
            else if(nums[i] > secondMax) secondMax = nums[i];
        }
        return (firstMax >= 2 * secondMax) ? idx : -1;
    }
}
