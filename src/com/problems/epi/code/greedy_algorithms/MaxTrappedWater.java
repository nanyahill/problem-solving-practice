package com.problems.epi.code.greedy_algorithms;

import java.util.List;

/**
 * Brute Force: Generate all the pairs of indices then find the max
 * Understanding the problem: Amount of trapped water = width * height
 * width = difference in array indices, height = min(heights[i], heights[j])
 * Key Insights:
 * * * start with the widest pair
 * * * for any pair i and j, if heights[i] > heights[j] then move j down because any water trapped
 * * * between k and j would ALWAYS be less than water trapped between i and j
 *  * * for any pair i and j, if heights[i] < heights[j] then move i up because any water trapped
 *  * * between i and k would ALWAYS be less than water trapped between i and j
 *  Algorithm:
 *  Iterate over all heights using two pointers
 *  compute trapped water
 *  check if max trapped water needs to be updated
 *  check if i or j need to move up or down
 */
public class MaxTrappedWater {

    // Time: O(n), Space: O(1)
    public static int findMaxTrappedWater(List<Integer> heights) {
        if(heights == null || heights.size() == 0) return -1;
        int maxTrappedWater = Integer.MIN_VALUE;
        int i = 0, j = heights.size() - 1;
        while(i < j) {
            int width = j - i;
            int height = Math.min(heights.get(i), heights.get(j));
            int trappedWater = width * height;
            maxTrappedWater = Math.max(trappedWater, maxTrappedWater);
            if(heights.get(i) > heights.get(j)) j--;
            else i++;
        }
        return maxTrappedWater;
    }
}
