package com.problems.more_epi_related_practice.code.linkedlists;

import com.util.ListNode;

public class ReOrderList {
    public void reorderList(ListNode<Integer> head) {
        if (head == null) return;
        ListNode<Integer> middleNode = findMiddleNode(head);
        ListNode<Integer> reversedMiddleNode = reverse(middleNode);
        ListNode<Integer> l1 = head;
        ListNode<Integer> l2 = reversedMiddleNode;
        while (l2 != null && l2.next != null) {
            ListNode<Integer> tmp = l1.next;
            l1.next = l2;
            l1 = tmp;

            tmp = l2.next;
            l2.next = l1;
            l2 = tmp;
        }
    }

    private ListNode<Integer> findMiddleNode(ListNode<Integer> head) {
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode<Integer> reverse(ListNode<Integer> head) {
        ListNode<Integer> curr = head;
        ListNode<Integer> prev = null;
        ListNode<Integer> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
