package com.problems.epi.code.sorting.learning;

/**
 * Key Ideas:
 * - Improves insertion sort algorithm.
 * - Splits original array into multiple subarrays, then h-sort subarrays.
 * - h-sort means rearrange the array such that elements at every hth positions form a sorted sequence.
 * - h consists of an appropriate set of decrementing sequence that ends in 1. e.g. 10, 5, 2, 1.
 * - Each value of h can be called a gap.
 * - A subarray consists of elements that are h elements apart.
 * - Overall, the original array is sorted by h-sorting subarrays for each value of h.
 */
public class ShellSort {

    public static int[] shellSort(int[] A) {
        if (A == null || A.length == 0) return null;
        int gap = 1;
        while (gap < A.length) gap = 3 * gap + 1;
        shellSort(A, gap);
        return A;
    }

    private static void shellSort(int[] A, int h) {
        while (h >= 1) {
            for (int i = h; i < A.length; i++) {
                int hole = i;
                while (hole > h && less(A, hole, hole - h)) {
                    swap(A, hole, hole - h);
                    hole -= h;
                }
            }
            h /= 3;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static boolean less(int[] A, int i, int j) {
        return A[i] < A[j] ? true : false;
    }
}
