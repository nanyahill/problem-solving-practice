package com.problems.ctci.chapter2;

import com.util.ListNode;

public class Question2_3 {
    public static boolean deleteMiddleNode(ListNode<Integer> n) {
        if(n == null || n.next == null) return false;
        ListNode<Integer> next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
