package com.problems.epi.code.greedy_algorithms;

import java.util.List;

public class MaxTrappedWater {

    // Time: O(n), Space: O(1)
    public static int findMaxTrappedWater(List<Integer> heights) {
        if(heights == null || heights.size() == 0) return -1;
        int maxVol = Integer.MIN_VALUE;
        int i = 0, j = heights.size() - 1;
        while(i < j) {
            int width = j - i;
            int height = Math.min(heights.get(i), heights.get(j));
            int vol = width * height;
            if(vol > maxVol) maxVol = vol;
            if(heights.get(i) > heights.get(j)) j--;
            else i++;
        }
        return maxVol;
    }
}
