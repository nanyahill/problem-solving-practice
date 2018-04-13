package com.problems.epi.code.sorting.learning;

/**
 * Key Idea: Compare adjacent elements of the array and exchage them if they are out of order
 * Optimizations:
 * - inner loop goes from 0..n-i-1 since the end of array is already sorted
 * - boolean flag checks if array is already sorted using the inner loop
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < nums.length - 1; j++) {
                if(nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
        return nums;
    }

    public static int[] bubbleSort_Optimization(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        for(int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for(int j = 0; j < nums.length - i - 1; j++) { // Optimization I- end of array is already sorted
                if(nums[j] > nums[j + 1]) {
                    flag = true;
                    swap(nums, j, j + 1);
                }
            }
            if(flag == false) break; // Optimization II- no swap happened, hence array is already sorted
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
