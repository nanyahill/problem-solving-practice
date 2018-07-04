package com.problems.epi.test.linked_lists;


import com.problems.epi.code.linked_lists.TestCyclicity;
import com.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class TestCyclicityTest {

    @Test
    public void testCyclicity() {
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2));
        head.next.next = head;
        //head.next.next =  new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, head.next)));
        ListNode<Integer> expected = null;// head.next;

        ListNode<Integer> head2 = new ListNode<>(1, null);
        ListNode<Integer> expected2 = head;
        ListNode<Integer> actual = TestCyclicity.hasCycle(head);
        Assert.assertEquals(expected2, actual);
    }
}
