package com.problems.epi.code.arrays;

import java.util.Random;

public class OfflineSampling {

    public static int[] randomSampling(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            // Generate a random index and add i
            // You need to generate random numbers within a range for each iteration
            // Example if k = 3, [1,2,3,4,5]
            // 1st iteration: range is 0 - 4 (all inclusive)
            // 2nd iteration: range is 1 - 4 (all inclusive)
            // 3nd iteration: range is 2 - 4 (all inclusive)
            // Rule of Thumb for generating random numbers in a range: int random_integer = rand.nextInt(upperbound-lowerbound) + lowerbound)
            // source: https://stackoverflow.com/questions/11743267/get-random-numbers-in-a-specific-range-in-java?lq=1
            int r_index = i + rand.nextInt(len - i);
            int tmp = nums[i];
            nums[i] = nums[r_index];
            nums[r_index] = tmp;
        }
        return nums;
    }
}
