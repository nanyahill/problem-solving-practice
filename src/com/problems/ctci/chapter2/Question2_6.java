package com.problems.ctci.chapter2;

import com.util.ListNode;

public class Question2_6 {

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = findMiddleNode(head);
        ListNode left = head;
        ListNode right = reverseList_Iter(slow); // good idea to use iterative approach
        return isEqual(left, right);
    }

    private static ListNode reverseList_Rec(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = reverseList_Rec(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private static ListNode reverseList_Iter(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static boolean isEqual(ListNode n1, ListNode n2) {
        while(n1 != null && n2 != null) {
            if(n1.data != n2.data) return false; // ensure you do not need to use equals(..)
            n1 = n1.next;
            n2 = n2.next;
        }
        return true; // this is correct even though slow may have an extra node sometimes (odd length LL)
    }
}
