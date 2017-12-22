package com.problems.leetcode.bit_manipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nanya on 11/23/17.
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for(Integer n : nums) {
            res ^= n;
        }
        return res;
    }

    public static int singleNumberToo(int[] nums) {
        //int[] count = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        for(Integer n : map.keySet()) {
            if(map.get(n) == 1) {
                return n;
            }
        }
        return -1;
    }
}
