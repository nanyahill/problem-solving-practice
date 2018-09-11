package com.problems.leetcode.code.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Degree of an array means: the maximum frequency of any one of its elements.
 */
public class DegreeOfArray {

    /**
     * Key Insight: The subarray must contain all the appearances of the highest frequency number
     * (.i.e the degree of the array)
     * Time complexity: O(n)
     * Space complexity: O(n)
     * Note we cannot do better space-wise because you need at least a dictionary to store the frequency count
     * Also, you cannot do better by sortng the array first because that destroys the order of input elements
     * which is required to solve the problem
     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap<>(), count = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(!left.containsKey(x)) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        int result = nums.length;
        int degree = Collections.max(count.values());
        for(Integer x : count.keySet()) {
            if(count.get(x) == degree)
                result = Math.min(result, right.get(x) - left.get(x) + 1);
        }
        return result;
    }
}
