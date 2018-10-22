package com.problems.ctci.chapter2;

import com.util.ListNode;

public class Question2_2 {

    public static ListNode returnKthLastNode(ListNode head, int k) {
        if(head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(k-- > 0) {
            if(fast == null) return null;
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
