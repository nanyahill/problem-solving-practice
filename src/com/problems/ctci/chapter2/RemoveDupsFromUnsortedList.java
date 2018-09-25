package com.problems.ctci.chapter2;

import com.util.ListNode;

import java.util.*;

public class RemoveDupsFromUnsortedList {

    /**
     * Time Complexity : O(n)
     * @param head
     * @return
     */
    public static ListNode<Integer> removeDuplicates_ExtraSpace(ListNode<Integer> head) {
        if(head == null || head.next == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            if(set.contains(curr.data)) {
                prev.next = curr.next;
            }
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }

    /**
     * Time Complexity: O(n^2)
     * @param head
     * @return
     */
    public static ListNode<Integer> removeDuplicates_ConstantSpace(ListNode<Integer> head) {
        if(head == null || head.next == null) return head;
        ListNode<Integer> curr = head;
        while(curr != null) {
            ListNode<Integer> runner = curr;
            while(runner.next != null) {
                if(runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                }
                else runner = runner.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static ListNode<Integer> removeDuplicates_SortedList(ListNode<Integer> head) {
        if(head == null || head.next == null) return head;
        // head = mergeSort(head);
        ListNode<Integer> curr = head.next;
        ListNode<Integer> prev = head;
        while(curr != null) {
            if(prev.data == curr.data) {
                prev.next = curr.next;
            }
            else prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
