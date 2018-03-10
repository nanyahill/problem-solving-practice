package com.problems.epi.code.sorting.learning;

import java.util.Random;

/**
 * This implements quicksort recursively. The iterative version uses a stack data structure
 * Time complexity for bth version is the same:
 * Avg: O(nlogn), Worst: O(n^2)
 * Space complexity is same too because a Stack is used in the iterative vesion to mimic the stack in the recursive version.
 */
public class QuickSort {

    public static int[] quickSort_Recursive(int[] A) {
        if(A == null || A.length == 0) return A;
        int lo = 0, hi = A.length - 1;
        quickSort_Recursive(A, lo, hi);
        return A;
    }

    private static void quickSort_Recursive(int[] A, int lo, int hi) {
        if(lo < hi) {
            Random rand = new Random();
            int pvt = rand.nextInt(hi - lo + 1) + lo; // instead of using RNG, pick pvt as the last element in A
            // Below is done in order to keep pvt separately and focus on the unsorted (non-pvt) elements
            swap(A, pvt, hi);
            int idx = partition(A, lo, hi);
            quickSort_Recursive(A, lo, idx - 1);
            quickSort_Recursive(A, idx + 1, hi);
        }
    }

    // Similar to the partition used in QuickSelect Algorithm (see OrderStatistic problem)
    private static int partition(int[] A, int lo, int hi) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        int i = lo - 1; // i = lo;
        int j = hi; // j = hi + 1;
        Integer v = A[hi]; // v = A[lo];
        while(i < j) {
            while(i < hi && A[++i] < v);
            while(j > lo && A[--j] > v);
            if(i >= j) break;
            swap(A, i, j);
        }
        swap(A, hi, i); // swap(A, lo, j);
        return i; // return j;
    }

    private static void swap(int[] A, int i, int j) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
