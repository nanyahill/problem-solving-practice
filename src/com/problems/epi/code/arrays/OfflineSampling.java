package com.problems.epi.code.arrays;

import java.util.Random;

/**
 * Created by Nanya on 12/19/17.
 */
public class OfflineSampling {

    public static int[] randomSampling(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        Random rand = new Random();
        for(int i = 0; i < k; i++) {
            int r_int = i + rand.nextInt(len - i);
            int tmp = nums[i];
            nums[i] = nums[r_int];
            nums[r_int] =  tmp;
        }
        return nums;
    }
}
