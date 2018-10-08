package com.problems.ctci.chapter10;

import java.util.BitSet;

public class Question10_8 {

    public static void findDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return;
        BitSet bitArray = new BitSet(32000);
        for(int i = 0; i < nums.length; i++) {
            if(bitArray.get(nums[i])) {
                System.out.println(nums[i]);
            }
            else bitArray.set(nums[i]);
        }
    }
}
