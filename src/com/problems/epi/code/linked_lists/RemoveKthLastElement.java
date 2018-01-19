package com.problems.epi.code.linked_lists;

import com.util.ListNode;

/**
 * The main insight is the kth element changes as you traverse the list.
 * The final kth element when you get to the end of the list (i.e. the last element) is your result.
 */
public class RemoveKthLastElement {

    /**
     * Efficient Solution: Two pointers (slow and fast) where the two pointers are always k distance apart.
     * Be careful about null pointer errors and off-by-one errors.
     * Also since you are transforming the input (deleting) use a dummy node.
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode removeKthToLast(ListNode head, int k) {
        if(head == null) return head;
        ListNode<Integer> dummy = new ListNode<>(0, head);
        ListNode<Integer> fast = dummy.next;
        int i = 0;
        while(i++ < k) fast = fast.next;
        ListNode slow = dummy;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
