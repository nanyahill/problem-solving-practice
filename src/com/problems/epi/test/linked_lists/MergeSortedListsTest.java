package com.problems.epi.test.linked_lists;

import com.problems.epi.code.linked_lists.MergeSortedLists;
import com.util.ListNode;
import org.junit.Test;

public class MergeSortedListsTest {

    @Test
    public void mergeSortedLists() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(11);
        ListNode expected = new ListNode(2);
        expected.next = new ListNode(3);
        expected.next.next = new ListNode(5);
        expected.next.next.next = new ListNode(7);
        expected.next.next.next.next = new ListNode(11);
        ListNode actual = MergeSortedLists.mergeSortedLists(l1, l2);
        while(expected != null) {
            assert expected.data == actual.data;
            expected = expected.next;
            actual = actual.next;
        }
    }
}
