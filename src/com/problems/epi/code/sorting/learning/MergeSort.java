package com.problems.epi.code.sorting.learning;

import com.problems.epi.code.linked_lists.MergeSortedLists;
import com.util.ListNode;

public class MergeSort {

    // This implementation is also known as top-down merge sort
    public static int[] mergeSort_Recursive_WithArrays(int[] A) {
        if(A == null || A.length == 0) return A;
        int lo = 0, hi = A.length - 1;
        int[] helper = new int[A.length];
        mergeSort_Recursive_WithArrays(A, helper, lo, hi);
        return A;
    }

    private static void mergeSort_Recursive_WithArrays(int[] A, int[] helper, int lo, int hi) {
        if(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort_Recursive_WithArrays(A, helper, lo, mid);
            mergeSort_Recursive_WithArrays(A, helper, mid + 1, hi);
            merge_WithArrays(A, helper, lo, mid, hi);
        }
    }

    /**
     * Key Ideas:
     * - merges pairs of adjacent arrays of 1 element, next merges for 2 elements, and so on up to 2^k elements
     * - The merge operation is similar as to the recursive version
     * Algorithm:
     * - Have two for loops- the outer loop keeps track of the width of the array that would be merging
     * - Run the merge for each adjacent array of the width in the input array, thus inner loop runs to end of input
     */
    public static int[] mergeSort_Iterative_WithArrays(int[] A) {
        if(A == null || A.length == 0) return A;
        int[] helper = new int[A.length];
        for(int width = 1; width < A.length; width *= 2) {
            for(int i = 0; i < A.length - width; i += 2*width) {
                int lo = i;
                int mid = lo + width - 1;
                int hi = Math.min(lo + 2*width - 1, A.length - 1);
                merge_WithArrays(A, helper, lo, mid, hi);
            }
        }
        return A;
    }

    private static void merge_WithArrays(int[] A, int[] helper, int lo, int mid, int hi) {
        for(int i = lo; i <= hi; i++) helper[i] = A[i];
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid) A[k] = helper[j++];
            if(j > hi) A[k] = helper[i++];
            else if(helper[i] <= helper[j]) A[k] = helper[i++];
            else A[k] = helper[j++];
        }
    }

    public static ListNode<Integer> mergeSort_WithLists(ListNode<Integer> head) {
        if(head == null || head.next == null) return head;
        ListNode<Integer> preSlow = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            preSlow = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        preSlow.next = null; // used to form two separate lists
        return MergeSortedLists.mergeSortedLists_WithDummyNode(mergeSort_WithLists(head), mergeSort_WithLists(slow));
    }
}
