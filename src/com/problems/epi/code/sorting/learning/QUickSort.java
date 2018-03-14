package com.problems.epi.code.sorting.learning;

import com.util.ListNode;

import java.util.Random;

/**
 * This implements quicksort recursively. The iterative version uses a stack data structure
 * Time complexity for bth version is the same:
 * Avg: O(nlogn), Worst: O(n^2)
 * Space complexity is same too because a Stack is used in the iterative vesion to mimic the stack in the recursive version.
 */
public class QuickSort {

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
        public HeadAndTail() {}
    }
    public static ListNode<Integer> quickSort_Recursive_WithLists(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;
        ListNode<Integer> tail = getTail(head);
        HeadAndTail headAndTail = new HeadAndTail();
        return quickSort_Recursive_WithLists(head, tail, headAndTail);
    }

    public static ListNode<Integer> quickSort_Recursive_WithLists(ListNode<Integer> head, ListNode<Integer> tail, HeadAndTail headAndTail) {
        if(head == null || head == tail) return head;
        ListNode pivot = partition_WithLists(head, tail, headAndTail);
        if(headAndTail.head != pivot) {
            ListNode<Integer> tmp = headAndTail.head;
            while (tmp != null && tmp.next != pivot) { tmp = tmp.next; }
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
