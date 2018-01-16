package com.problems.epi.test.linked_lists;


import com.problems.epi.code.linked_lists.TestCyclicity;
import com.problems.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestCyclicityTest {

    @Test
    public void testCyclicity() {
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2));
        head.next.next =  new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, head.next)));
        ListNode<Integer> expected = head.next;
        ListNode<Integer> actual = TestCyclicity.testCyclicity(head);
        Assert.assertEquals(expected, actual);
    }
}
