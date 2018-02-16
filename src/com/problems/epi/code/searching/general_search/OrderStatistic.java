package com.problems.epi.code.searching.general_search;

import java.util.Random;

/**
 * Key Insight:
 * Kth largest means that we want to get the N-K -th element in the array when sorted.
 * For Kth smallest means you want to get the kth element in the array when sorted.
 * When you partition an array around a pivot, p, you partially sort the array.
 * At the end of the partition, A[p] is in its final position.
 * Partitioning the left and right halves also places the pivot used for partitioning in its final position.
 * Hence, at any point in time, if the returned index of the final position of the pivot is the same as k,
 * then you would have found the kth largest/smallest element depending on the question.
 * Side Notes:
    - For the partition, you want to randomly select a pivot using a random number generator- this would ensure that the wprst case (O(n^2)) rarely happens.
    - Before partition, it is advisable to swap the first element with the element at the pivot.
    This helps to get the pivot out the way of the array partition.
    This is done because the pivot does not know where it will end up until the other elements are moved.
    When the other elements have been moved, the final position of 	the right pointer is the pivot's new position, hence the swap.
    Note that the pivot may also be swapped with the last element, in this case the position of i is returned rather than j.
    - Using prefix operators means that if swapping pivot with the first element,
    then j would be initialized to hi + 1 and j would be returned from the partition method.
    In the same way, if swapping pivot with the last element, then i would be initialized to lo - 1 and i would be returned from the partition method.
    - It is harder to do three-way partition (Dutch National Flag) for Quick select or Quick Sort.
 * Learning: This is a selection Algorithm. The version implemented here is called Quick Select.
    - It uses the same partition step (two-way partitioning) algorithm in Quick sort but it processes only one side of the partition.
    - Unlike quick sort which processes the two sides.
 */
public class OrderStatistic {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Comparable findKthLargest(Comparable[] A, int k) {
        if(A == null || A.length == 0) return 0;
        int lo = 0, hi = A.length - 1;
        Random rand = new Random();
        k = A.length - k;
        while(lo < hi) {
            int pvt = rand.nextInt(hi - lo + 1) + lo;
            swap(A, hi, pvt); // swap(A, lo, pvt);
            int j = partition(A, lo, hi);
            if(j == k) break;
            else if(j < k) lo = j + 1;
            else hi = j - 1;
        }
        return A[k];
    }

    private static int partition(Comparable[] A, int lo, int hi) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        int i = lo - 1; // i = lo;
        int j = hi; // j = hi + 1;
        Comparable v = A[hi]; // v = A[lo];
        while(i < j) {
            while(i < hi && less(A[++i],v));
            while(j > lo && less(v, A[--j]));
            if(i >= j) break;
            swap(A, i, j);
        }
        swap(A, hi, i); // swap(A, lo, j);
        return i; // return j;
    }

    private static void swap(Comparable[] A, int i, int j) {
        if(A == null || A.length == 0) throw new IllegalStateException();
        Comparable tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static boolean less(Comparable a, Comparable b) {
        if(a == b) return false;
        return a.compareTo(b) < 0;
    }
}
