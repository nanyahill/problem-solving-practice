package com.problems.epi.code.arrays;

import java.util.HashSet;
import java.util.Set;


public class RemoveDuplicatesFromSortedArray {

    /** O(n) space, O(n) time */
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
    /*
    Note: You could be asked to return the modified array (either with duplicates (or zeros) at the end of array)
    In that case you should do an actual swap on ln 35-36
     */
    public static int removeDuplicatesFromSortedArray_Efficient(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int writeIdx = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[writeIdx - 1]) {
                nums[writeIdx++] = nums[j];
            }
        }
        return writeIdx;
    }

    // Variant 1: Remove elements that equal to a key val
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int writeIdx = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[writeIdx++] = nums[j];
            }
        }
        return writeIdx;
    }

    // Variant 2: Remove duplicates such that each unique element appears at most twice
    public static int removeDuplicatesFromSortedArray(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int writeIdx = 1;
        int count = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[writeIdx - 1] == nums[j]) {
                count++;
            }
            else {
                count = 1;
            }
            if(count <= k) {
                nums[writeIdx++] = nums[j];
            }
        }
        return writeIdx;
    }
}
