package com.problems.epi.code.sorting;

import com.problems.epi.code.linked_lists.MergeSortedLists;
import com.util.ListNode;

/**
 * Key Insight: Sorting linkedlist efficiently is best done with merge sort because:
 *  - Merge in LinkedList happens in-place because insertions in the middle of the list is an O(1) operation
 * Algorithm:
 *  - Recursively, split the list into equal sized sublist in the middle.
 *  The middle can be found by iterating two pointers- one twice as fast as the other,
 *  When the fast reaches the end of the list, the slower pointer is at the middle.
 *  - Call merge on the sublists using the solution from the merge two sorted sublists problem
 */
public class SortListsEfficiently {

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
