package com.problems.epi.code.sorting.learning;

/**
 * Key Idea: Select the ith smallest element and swap it with the element at the ith position.
 * This way the ith smallest element is inserted in the correct position.
 * Time Complexity: O(n^2), worst case
 * Space complexity: O(1)
 */
public class SelectionSort {

    public static int[] selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx])
                    minIdx = j;
            }
            swap(nums, i, minIdx);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0) throw new IllegalStateException();
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
