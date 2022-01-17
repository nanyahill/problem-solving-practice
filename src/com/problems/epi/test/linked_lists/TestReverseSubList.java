package com.problems.epi.test.linked_lists;

import com.problems.epi.code.linked_lists.ReverseSubList;
import com.util.ListNode;
import org.junit.Test;

public class TestReverseSubList {

    @Test
    public void reverseSubListTest() {
        ListNode input = new ListNode(2);
        input.next = new ListNode(5);
        input.next.next = new ListNode(7);
        input.next.next.next = new ListNode(8);
        input.next.next.next.next = new ListNode(3);
        input.next.next.next.next.next = new ListNode(1);
        input.next.next.next.next.next.next = new ListNode(9);


        ListNode expected = new ListNode(2);
        expected.next = new ListNode(5);
        expected.next.next = new ListNode(1);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(8);
        expected.next.next.next.next.next = new ListNode(7);
        expected.next.next.next.next.next.next = new ListNode(9);
        ListNode actual = ReverseSubList.reverseSubListCleaner(input, 3, 6);

        while(expected != null) {
            assert expected.data.equals(actual.data);
            expected = expected.next;
            actual = actual.next;
        }
    }
}
