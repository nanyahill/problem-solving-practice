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
    public static ListNode mergeSortedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null || l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        else if(l1 != null && l2 == null) return l1;
        // Dummy node is used because the input lists are modified
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> current = dummy;
        while(l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode res = null;
        ListNode currRes = res;
        while(l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                if(res == null) {
                    res = l1;
                    currRes = l1;
                }
                else {
                    currRes.next = l1;
                    currRes = currRes.next;
                }
                l1 = l1.next;
            }
            else {
                if(res == null) {
                    res = l2;
                    currRes = l2;
                }
                else {
                    currRes.next = l2;
                    currRes = currRes.next;
                }
                l2 = l2.next;
            }
        }
        currRes.next = l1 == null ? l2 : l1;
        return res;
    }
}
