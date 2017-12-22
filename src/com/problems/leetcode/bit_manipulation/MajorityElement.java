package com.problems.leetcode.bit_manipulation;

/**
 * Created by Nanya on 11/21/17.
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        // Bit frequency table
        int[] bits = new int[32];

        // Work out bit frequency
        int res = 0;
        for(Integer num : nums) {
            for(int i = 0; i < 32; i++) {
                if(((num >>> i) & 1) == 1) {
                    bits[i]++;
                }
            }
        }

        // Recreate the majority number
        for(int i = 0; i < 32; i++) {
            if(bits[i] > (nums.length / 2)) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
