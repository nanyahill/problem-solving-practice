package com.problems.epi.code.sorting.learning;

import com.util.ListNode;
import java.util.Random;

/**
 * This implements quicksort recursively. The iterative version uses an auxillary stack data structure
 * Time complexity for bth version is the same:
 * Avg: O(nlogn), Worst: O(n^2)
 * Space complexity is same too because a Stack is used in the iterative vesion to mimic the stack in the recursive version.
 */
public class QuickSort {

    /**
     * Dual Pivot is similar to three-way except for the following points:
     *      * Two pivots are selected- the first and last elements are often used.
     *      * First pivot should be less than second pivot
     *      * In the loop, compare less than with A[lo] and greater than with A[hi]
     *      * When loop is finished, swap pivots to final positions
     *      * lt to gt do NOT contain elements equal to any of the pivots, rather contains elements > p1 < p2
     * Algorithm:
     *      - Select two pivots
     *      - Partition into three segments based on the two pivots (p1 & p2) as shown below
     *      lt, gt = final positions of p1 and p2
     *      -------------------------------------
     *      < p1 | p1 | > p1 < p2 | p2 | > p2
     *      -------------------------------------
     *              lt              gt
     *      - Recursively sort the three segments: lo to lt -1; lt +1 to gt - 1; gt + 1 to hi
     *
     */
    public static int[] quickSort_DualPivot(int[] A) {
        if (A == null || A.length == 0) return A;
        int lo = 0, hi = A.length - 1;
        quickSort_DualPivot(A, lo, hi);
        return A;
    }

    private static void quickSort_DualPivot(int[] A, int lo, int hi) {
        if (lo < hi) {
            if (A[lo] > A[hi]) swap(A, lo, hi);
            int lt = lo + 1, eq = lt, gt = hi - 1;
            while (eq <= gt) {
                if (A[eq] < A[lo]) swap(A, eq++, lt++);
                else if (A[eq] > A[hi]) swap(A, eq, gt--);
                else eq++;
            }
            // Swap the two pivots to their final positions
            swap(A, lo, --lt);
            swap(A, hi, ++gt);
            quickSort_DualPivot(A, lo, lt - 1);

            /** if statement is useful for cases when the two pivots are equal (i.e array contains duplicates)
                note that there are some cases where there is no elements between pivot 1 and pivot 2
                    for example: pivot 1 = 3, pivot 2 = 4
                cases like this are handled at the beginning of the method with check lo < hi
             */
            if(A[lt] < A[gt]) quickSort_DualPivot(A, lt + 1, gt - 1);
            quickSort_DualPivot(A, gt + 1, hi);
        }
    }

    /**
     * Algorithm:
     *      - Select a pivot- could be random, first element or last element
     *      - Partition into two segments based on the pivot (p1) as shown below
     *      lt to gt = contain elements equal to p1
     *      -----------------------------------
     *       < p1    |      p1     |   > p1
     *      -----------------------------------
     *                   lt, gt
     *      - Recursively sort the two segments: lo to lt -1; gt + 1 to hi
     *
     */
    public static int[] quickSort_ThreeWay(int[] A) {
        if (A == null || A.length == 0) return A;
        int lo = 0, hi = A.length - 1;
        quickSort_ThreeWay(A, lo, hi);
        return A;
    }

    // The partition method used here is exactly the same one implemented for DNF problem
    private static void quickSort_ThreeWay(int[] A, int lo, int hi) {
        if (lo < hi) {
            // Instead of using an RNG either the first or last element may be picked
            Random rand = new Random();
            int pvtIdx = rand.nextInt(hi - lo + 1) + lo;
            int pvt = A[pvtIdx];
            //int pvt = A[hi];
            //int pvt = a[lo];
            int lt = lo, eq = lo, gt = hi;
            while (eq <= gt) { // <= because all elements need to be checked/compared
                if (A[eq] < pvt) swap(A, eq++, lt++);
                else if (A[eq] > pvt) swap(A, eq, gt--);
                else eq++;
            }
            quickSort_ThreeWay(A, lo, lt - 1);
            quickSort_ThreeWay(A, gt + 1, hi);
        }
    }

    public static int[] quickSort_Recursive_WithArrays(int[] A) {
        if (A == null || A.length == 0) return A;
        int lo = 0, hi = A.length - 1;
        quickSort_Recursive_WithArrays(A, lo, hi);
        return A;
    }

    private static void quickSort_Recursive_WithArrays(int[] A, int lo, int hi) {
        if (lo < hi) {
            Random rand = new Random();
            int pvt = rand.nextInt(hi - lo + 1) + lo; // instead of using RNG, pick pvt as the last element in A
            // Below is done in order to keep pvt separately and focus on the unsorted (non-pvt) elements
            swap(A, pvt, hi);
            int idx = partition_WithArrays(A, lo, hi);
            quickSort_Recursive_WithArrays(A, lo, idx - 1);
            quickSort_Recursive_WithArrays(A, idx + 1, hi);
        }
    }

    // Similar to the partition_WithArrays used in QuickSelect Algorithm (see OrderStatistic problem)
    private static int partition_WithArrays(int[] A, int lo, int hi) {
        if (A == null || A.length == 0) throw new IllegalStateException();
        // i is initialized as below in order to be able to use the prefix operator
        // prefix operator are important here because you want to decrement BEFORE comparing
        // this is needed so that the loop stops as soon as an element fails to satisfy the condition
        int i = lo - 1; // i = lo;
        int j = hi; // j = hi + 1;
        Integer v = A[hi]; // v = A[lo];
        while (i < j) {
            while (i < hi && A[++i] < v) ;
            while (j > lo && A[--j] > v) ;
            if (i >= j) break;
            swap(A, i, j);
        }
        swap(A, hi, i); // swap(A, lo, j);
        return i; // return j;
    }

    private static void swap(int[] A, int i, int j) {
        if (A == null || A.length == 0) throw new IllegalStateException();
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    // Useful to track the new head and new tail after partition.
    // This is useful because Java copies and passes a reference as value
    // More details: https://www.javaworld.com/article/2077424/learn-java/does-java-pass-by-reference-or-pass-by-value.html
    public static class HeadAndTail {
        ListNode head;
        ListNode tail;

        public HeadAndTail() {
        }
    }

    public static ListNode<Integer> quickSort_Recursive_WithLists(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;
        ListNode<Integer> tail = getTail(head);
        HeadAndTail headAndTail = new HeadAndTail();
        return quickSort_Recursive_WithLists(head, tail, headAndTail);
    }

    public static ListNode<Integer> quickSort_Recursive_WithLists(ListNode<Integer> head, ListNode<Integer> tail, HeadAndTail headAndTail) {
        if (head == null || head == tail) return head;
        ListNode pivot = partition_WithLists(head, tail, headAndTail);
        if (headAndTail.head != pivot) {
            ListNode<Integer> tmp = headAndTail.head;
            while (tmp != null && tmp.next != pivot) {
                tmp = tmp.next;
            }
            tmp.next = null;
            headAndTail.head = quickSort_Recursive_WithLists(headAndTail.head, tmp, new HeadAndTail());
            tmp = getTail(headAndTail.head);
            tmp.next = pivot;
        }
        pivot.next = quickSort_Recursive_WithLists(pivot.next, headAndTail.tail, new HeadAndTail());
        return headAndTail.head;
    }

    //private static ListNode partition_WithLists(ListNode<Integer> head, ListNode<Integer> tail, ListNode<Integer> newHead, ListNode<Integer> newTail) {
    private static ListNode partition_WithLists(ListNode<Integer> head, ListNode<Integer> tail, HeadAndTail headAndTail) {
        ListNode<Integer> curr = head;
        ListNode<Integer> pivot = tail;
        ListNode<Integer> prev = null;
        ListNode<Integer> tail_pivot = pivot;
        while (curr != pivot) {
            if (curr.data < pivot.data) {
                if (headAndTail.head == null) headAndTail.head = curr;
                prev = curr;
                curr = curr.next;
            } else {
                if (prev != null) prev.next = curr.next;
                ListNode tmp = curr.next;
                curr.next = null;
                tail_pivot.next = curr;
                tail_pivot = curr;
                curr = tmp;
            }
        }
        if (headAndTail.head == null) headAndTail.head = pivot;
        headAndTail.tail = tail_pivot;
        return pivot;
    }

    private static ListNode getTail(ListNode<Integer> head) {
        ListNode<Integer> tail = head;
        if (head == null || head.next == null) return tail;
        while (tail != null && tail.next != null) tail = tail.next;
        return tail;
    }

    public static void main(String[] args) {
        //ListNode<Integer> head = new ListNode<>(4);
        ListNode<Integer> head = new ListNode<>(4, new ListNode<>(5));
        head.next.next = new ListNode<>(2, new ListNode<>(6));
        head.next.next.next.next = new ListNode<>(1, new ListNode<>(3));
        ListNode<Integer> res = quickSort_Recursive_WithLists(head);
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }

}
