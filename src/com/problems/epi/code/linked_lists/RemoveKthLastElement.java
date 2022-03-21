package com.problems.epi.code.linked_lists;

import com.util.ListNode;

/**
 * The main insight is the kth element changes as you traverse the list.
 * The final kth element when you get to the end of the list (i.e. the last element) is your result.
 * Brute force: Traverse the list to get the length, then traverse the list up till length - k + 1
 * Inefficient because we are traversing the list twice
 * Efficient: Maintain two pointers, slow & fast that will always be k distance apart
 * That is, k nodes apart: 5->4->8->2->3 (if slow is at 5 and fast os at 3, they are 3 nodes apart)
 */
public class RemoveKthLastElement {

    /**
     * Efficient TreeTraversal_Recursive: Two pointers (slow and fast) where the two pointers are always k distance apart.
     * Be careful about null pointer errors and off-by-one errors.
     * Also since you are transforming the input (deleting) use a dummy node to take care of corner cases-
     * Corner cases: 1) Removing the last node from list with one node (4->null, 1)
     * 2) Removing the head node from a list with two nodes (4->9->null, 2)
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode removeKthToLast(ListNode head, int k) {
        if(head == null) return head;
        ListNode<Integer> dummy = new ListNode<>(0, head);
        ListNode<Integer> fast = dummy.next; //head
        int i = 0;
        /**
         * Be careful in this while loop
         * If fast is starting from head (or dummy.next) then you loop k times
         * Else if fast is starting from the dummy node (like slow) then loop k + 1 times
         */
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
