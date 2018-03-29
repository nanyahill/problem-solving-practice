package com.problems.epi.code.sorting.learning;

/**
 * This class implements heapsort. Heapsort can be broken down into two stages:
 ******* 1. Heap Construction- can be done in two ways:
 *************** 1.1 Swim: takes nlogn not so efficient. Main Idea of swim- each element is inserted successively into the heap.
 *************** 1.2 Sink: takes n time. Main Idea of sink- each position in the array is the root of a small subheap.
 ******* 2. Sort Down: Takes O(nlogn) time because you are deleting the max (logn) for n - 1 elements (first element is already in place).
 */
public class HeapSort {
    public static int[] heapSort(int[] A) {
        if (A == null || A.length == 0) return null;
        // create a max heap using sink method because it is more efficient than swim method
        // max-heap is created because we are sorting in ascending order, if otherwise, use min-heap.
        createMaxHeap_UsingSink(A);
        int j = A.length;
        // Sort down from n to 2 (that is n - 1 elements)
        while (j > 1) {
            swap(A, 1, j--);
            sink(A, 1, j);
        }
        return A;
    }

    private static void createMaxHeap_UsingSink(int[] A) {
        if (A == null || A.length == 0) return;
        int n = A.length, mid = n / 2;
        for (int i = mid; i > 0; i--) sink(A, i, n);
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i - 1];
        A[i - 1] = A[j - 1];
        A[j - 1] = tmp;
    }

    private static void sink(int[] A, int i, int n) {
        while (2 * i <= n) {
            int k = 2 * i;
            if (k < n && less(A, k, k + 1) < 0) k++;
            if (less(A, i, k) > 0) break;
            swap(A, i, k);
            i = k;
        }
    }

    private static int less(int[] A, int i, int j) {
        return A[i - 1] < A[j - 1] ? -1 : A[i - 1] > A[j - 1] ? 1 : 0;
    }
}