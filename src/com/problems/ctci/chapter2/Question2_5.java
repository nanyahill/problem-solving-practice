package com.problems.ctci.chapter2;

import com.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question2_5 {

    // Assumes LSD is the head of list
    public static ListNode sumLists_LSD(ListNode<Integer> L1, ListNode<Integer> L2) {
        if(L1 == null || L2 == null) return L1 == null ? L2 : L1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(L1 != null || L2 != null || carry != 0) {
            int sum = (L1 != null ? L1.data : 0) + (L2 != null ? L2.data : 0) + carry;
            ListNode n = new ListNode(sum % 10);
            carry = sum / 10;
            curr.next = n;
            curr = curr.next;
            L1 = L1 != null ? L1.next : null;
            L2 = L2 != null ? L2.next : null;
        }
        return dummy.next;
    }

    // Assumes MSD is the head of list
    public static ListNode sumLists_MSD(ListNode<Integer> L1, ListNode<Integer> L2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while(L1 != null) {
            stack1.push(L1.data);
            L1 = L1.next;
        }
        while(L2 != null) {
            stack2.push(L2.data);
            L2 = L2.next;
        }
        int carry = 0;
        ListNode curr = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = (!stack1.isEmpty() ? stack1.pop() : 0) + (!stack2.isEmpty() ? stack2.pop() : 0) + carry;
            ListNode n = new ListNode(sum % 10);
            n.next = curr;
            curr = n;
            carry = sum / 10;
        }
        return curr;
    }
}
