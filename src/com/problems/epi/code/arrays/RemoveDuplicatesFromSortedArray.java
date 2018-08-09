package com.problems.epi.code.arrays;

import java.util.HashSet;
import java.util.Set;


public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicatesFromSortedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        int countOfUniqueElements = 0;
        for (Integer num : nums) {
            if (set.add(num)) {
                countOfUniqueElements++;
            }
        }
        return countOfUniqueElements;
    }

    /** O(1) space, O(n) time */
    public static int removeDuplicatesFromSortedArray_Efficient(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int writeIdx = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[writeIdx++] = nums[j];
            }
        }
        return writeIdx;
    }
}
