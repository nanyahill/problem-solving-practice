package com.problems.more_epi_related_practice.code.greedy;

public class MaximumSubArraySum {

    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxOverAll = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxOverAll = Math.max(maxOverAll, currSum);
            if (currSum < 0) currSum = 0;
        }
        return maxOverAll;
    }
}
