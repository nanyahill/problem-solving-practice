package com.problems.epi.code.linked_lists;

import com.util.ListNode;

/**
 * Created by Nanya on 1/12/18.
 */
public class ReverseSubList {
    /**
     * 1) Common approach to mind is  to extract the sublist, reverse it, and place it back in its original position.
     * This method requires a several pointer variables to be maintained.
     * 2) A cleaner approach is to see the reversal of the sublist as if the leftmost element (position m) in the list
     * is being bubbled to the rightmost position (position n).
     * NOTE: We use a dummy node here because the solution transforms the list somewhere between the beginning and the end inclusive.
     * NOTE: Index for s and f start at 1. Thus, first node is at index 1, second node at index 2, etc...
     * Time Complexity: O(n) where n is the nth node in the original list
     * Space Complexity: O(1)
     */
    public static ListNode<Integer> reverseSubListCleaner(ListNode<Integer> head, int s, int f) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        int k = 1;
        while(k++ < s) pre = pre.next;
        ListNode start = pre.next;
        while(s++ < f) {
            ListNode tmp = start.next;
            start.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

    /**
     * A not so clean solution.
     * Idea: Extract the sublist from the original list, reverse it, then insert it back to the original list
     * Time complexity: O(n)
     * Space Complexity: O(1) but uses a lot of variables
     */
    public static ListNode<Integer> reverseSubListToo(ListNode<Integer> head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode<Integer> rev_start = null, rev_end = null, rev_end_next = null, rev_pre = null;
        ListNode<Integer> dummy = new ListNode<Integer>(0, head);
        ListNode<Integer> curr = dummy.next;
        int i = 1;
        while(i <= n && curr != null) {
            if(i < m) rev_pre = curr;
            if(i == m) {
                rev_start = curr;
            }
            if(i == n) {
                rev_end = curr;
                rev_end_next = curr.next;
            }
            curr = curr.next;
            i++;
        }
        rev_end.next = null;
        rev_end = reverseList(rev_start);

        if(rev_pre != null) rev_pre.next = rev_end;
        else head.next = rev_end;

        rev_start.next = rev_end_next;
        return head;
    }

    /**
     * Note that this method does not use a dummy node
     * because we are transforming the list from the beginning to the end exactly
     * Good example of when we do not need dummy node
     */
    private static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if(head == null || head.next == null) return head;
        ListNode<Integer> curr = head;
        ListNode<Integer> prev = null;
        ListNode<Integer> next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
