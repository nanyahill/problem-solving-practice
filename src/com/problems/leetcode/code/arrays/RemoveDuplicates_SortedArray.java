package com.problems.leetcode.code.arrays;

/**
 * Created by Nanya on 9/29/17.
 */
public class RemoveDuplicates_SortedArray {

    //public class TreeTraversal_Recursive {
    public static int removeDups(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int idx = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[idx] = nums[j];
                idx++;
            }
        }
        return idx;
    }
    // }

    public static int removeDuplicates(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0, index = 0;
        int j = i + 1;
        while (j < array.length) {
            if (array[i] != array[j]) {
                array[++index] = array[j];
                i = j;
            }
            j++;
        }
        return index + 1;
    }

    public static void main(String args[]) {
        int[] array = {1, 1, 1, 1, 1, 2, 3, 3, 5, 8, 8};
        // System.out.print(removeDuplicates(array));
        String s = "   b";
        String[] arr = s.split(" ");
        System.out.print(arr[0]);
        String sr = Integer.toBinaryString(215);
        System.out.print(Integer.toBinaryString(8 >>> 32));
    }
}
