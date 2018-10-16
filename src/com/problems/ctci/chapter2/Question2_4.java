package com.problems.ctci.chapter2;

import com.util.ListNode;

public class Question2_4 {

    // Maintains stability of list elements
    public static ListNode<Integer> partitionLinkedList_Stable(ListNode<Integer> node, int pvt) {
        if (node == null || node.next == null) return node;
        ListNode smallerHead = new ListNode(0, null);
        ListNode equalHead = new ListNode(0, null);
        ListNode largerHead = new ListNode(0, null);
        ListNode smallerCurr = smallerHead;
        ListNode equalCurr = equalHead;
        ListNode largerCurr = largerHead;
        ListNode<Integer> curr = node;
        while (curr != null) {
            if (curr.data < pvt) {
                smallerCurr.next = curr;
                smallerCurr = smallerCurr.next;
            } else if (curr.data > pvt) {
                largerCurr.next = curr;
                largerCurr = largerCurr.next;
            } else {
                equalCurr.next = curr;
                equalCurr = equalCurr.next;
            }
            curr = curr.next;
        }
        smallerCurr.next = equalHead.next;
        equalCurr.next = largerHead.next;
        largerCurr.next = null;
        return smallerHead.next;
    }

    public static ListNode partitionLinkedList_NotStable(ListNode<Integer> node, int pvt) {
        if(node == null || node.next == null) return node;
        ListNode head = node;
        ListNode tail = node;
        while(node != null) {
            ListNode next = node.next;
            if(node.data < pvt) {
                node.next = head;
                head = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}
