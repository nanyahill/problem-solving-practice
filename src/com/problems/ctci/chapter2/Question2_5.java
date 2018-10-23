package com.problems.ctci.chapter2;

import com.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question2_5 {

    // Assumes LSD is the head of list
    public static ListNode sumLists(ListNode L1, ListNode L2) {
        if(L1 == null || L2 == null) return L1 == null ? L2 : L1;
        ListNode dummy = new ListNode(0);
        ListNode<Integer> curr1 = L1;
        ListNode<Integer> curr2 = L2;
        ListNode curr3 = dummy;
        int carry = 0;
        while(curr1 != null || curr2 != null || carry != 0) {
            ListNode node = new ListNode(0);
            int sum = (curr1 != null ? curr1.data : 0) + (curr2 != null ? curr2.data : 0) + carry;
            node.data = sum % 10;
            carry = sum / 10;
            curr3.next = node;
            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;
            curr3 = curr3.next;
        }
        return dummy.next;
    }

    // Assumes MSD is the head of list
    public static ListNode sumLists(ListNode<Integer> L1, ListNode<Integer> L2) {
        if(L1 == null || L2 == null) return L1 == null ? L2 : L1;
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while(L1 != null) {
            stack1.offerLast(L1.data);
            L1 = L1.next;
        }

        while(L2 != null) {
            stack2.offerLast(L2.data);
            L2 = L2.next;
        }

        int carry = 0;
        ListNode result = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if(!stack1.isEmpty()) sum += stack1.pollLast();
            if(!stack2.isEmpty()) sum += stack2.pollLast();
            ListNode head = new ListNode(sum % 10);
            head.next = result;
            result = head;
            carry = sum / 10;
        }
        return result;
    }
}
