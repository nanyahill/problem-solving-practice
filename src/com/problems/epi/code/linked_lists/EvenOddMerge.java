package com.problems.epi.code.linked_lists;

import com.util.ListNode;

/**
 * The key insight: create two separate lists one for odds and one for even. Then merge the two lists together.
 * Brute-Force: Use additional storage, e.g two stacks- oddStack and evenStack. This isn't very efficient.
 */
public class EvenOddMerge {

    /**
     * More efficient: Avoid the use of additional storage, by reusing the existing list nodes. Something like in-place.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> head) {
        if(head == null || head.next == null) return head;
        ListNode<Integer> even = head;
        ListNode<Integer> odd = even.next;
        ListNode<Integer> oddHead = odd;
        while(odd != null && odd.next != null) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = oddHead;
        return head;
    }
}
