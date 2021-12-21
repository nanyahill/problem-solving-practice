package com.problems.epi.code.linked_lists;

import com.util.ListNode;


public class MergeSortedLists {

    /**
     * 1) The two lists are already sorted;
     * hence you can compare elements in corresponding positions in the two lists to find the minimum.
     * 2) Two pointer can be used here where you advance the pointer of the first list
     * if a minimum element is found in that list else advance the pointer of the second list.
     * Time Complexity: O(n + m)
     * Space complexity: O(1)
     */
    public static ListNode mergeSortedLists_WithDummyNode(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // Dummy node is used because the input lists are modified
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static ListNode mergeSortedLists_WithoutDummyNode(ListNode<Integer> L1, ListNode<Integer> L2) {
        if (L1 == null) return L2;
        if (L2 == null) return L1;
        ListNode<Integer> res = null;
        if (L1.data <= L2.data) {
            res = L1;
            L1 = L1.next;
        } else {
            res = L2;
            L2 = L2.next;
        }
        ListNode<Integer> curr = res;
        while (L1 != null && L2 != null) {
            if (L1.data <= L2.data) {
                curr.next = L1;
                L1 = L1.next;
            } else {
                curr.next = L2;
                L2 = L2.next;
            }
            curr = curr.next;
        }
        curr.next = L1 == null ? L2 : L1;
        return res;
    }

    public static ListNode mergeTwoSortedLists_Recursion(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if(l1.data <= l2.data) {
            l1.next = mergeTwoSortedLists_Recursion(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoSortedLists_Recursion(l1, l2.next);
            return l2;
        }
    }
}
