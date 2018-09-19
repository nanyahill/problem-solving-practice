package com.problems.epi.code.searching.general_search;

import java.util.List;

public class SearchRowColSortedMatrix {

    // At most m + n - 1 elements are inspected
    public static boolean search2DSortedArray(List<List<Integer>> nums, int val) {
        if(nums == null || nums.size() == 0) return false;
        int top = 0;
        int right = nums.get(top).size() - 1;
        while(top < nums.size() && right >= 0) {
            if(nums.get(top).get(right) == val) return true;
            else if(nums.get(top).get(right) < val) top++;
            else right--;
        }
        return false;
    }
}
