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
            // You add i because you don't want to generate the same random index twice
            // Also because you want a random integer at least equal to the current index i
            int r_int = i + rand.nextInt(len - i);
            int tmp = nums[i];
            nums[i] = nums[r_int];
            nums[r_int] = tmp;
        }
        return nums;
    }
}
