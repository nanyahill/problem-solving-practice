package com.problems.epi.code.searching.binary_search;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindEntryEqualToIndex {

    // Assumes sorted array has distinct elements
    public static int findEntryEqualIndex(List<Integer> nums) {
        if(nums == null || nums.size() == 0) return -1;
        int lo = 0;
        int hi = nums.size() - 1;
        while(lo <= hi) {
            int mid = lo + ((hi - lo))/2;
            int diff = nums.get(mid) - mid;
            if(diff == 0) return mid;
            else if(diff < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

}
