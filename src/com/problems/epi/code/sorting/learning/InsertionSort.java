package com.problems.epi.code.sorting.learning;

import com.util.ListNode;

public class InsertionSort {

    /**
     * Key Ideas:
     * - Maintain two list- sorted list (left-side) and unsorted list (right-side)
     * - At every iteration, an element is picked from the unsorted list and inserted into their correct position
     * in the sorted list by shifting pre-existing sorted elements.
     * Time: O(n^2), worst case.
     * Time: O(n), best case
     * Space: O(1)
     */
    public static int[] insertionSort_Arrays(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        // start from 1 because you assume nums[0] is the sorted list while nums[1]..nums[n-1] is unsorted
        for (int i = 1; i < nums.length; i++) {
            // analogy: create a hole in the wall to fill up
            int hole = i;
            while (hole > 0 && nums[hole - 1] > nums[hole]) {
                swap(nums, hole, hole - 1);
                hole--;
            }
        }
        return nums;
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    public static int[] insertionSort_Arrays_Cleaner(int[] A) {
        if (A == null || A.length == 0) return null;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j > 0 && A[j - 1] > A[j]; j--)
                swap(A, j, j - 1);
        }
        return A;
    }

    /**
     * The main difference in this insertion sort algo is that insertion is quick and easy
     * Takes O(1) space. Although time is still O(n^2)
     * When a value is misplaced the sorted portion of the list is traversed up until
     * the preceding element before the correct position is found.
     * The LinkedList opeartion to insert an element in correct position is:
     * Delete the element from its current position
     * Insert it into the new position (similar to insertBefore() of MyLinkedList)
     */
    public static ListNode insertionSort_LinkedList(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;
        ListNode<Integer> dummy = new ListNode(0);
        dummy.next = head;
        ListNode<Integer> curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data <= curr.next.data) {
                curr = curr.next;
                continue;
            }
            ListNode<Integer> hole = curr.next;
            ListNode<Integer> pre = dummy;
            while (pre.next != null && pre.next.data < hole.data) pre = pre.next;
            ListNode temp = pre.next;
            pre.next = hole;
            curr.next = hole.next;
            hole.next = temp;
        }
        return dummy.next;
    }

    private static void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0) throw new IllegalStateException();
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
