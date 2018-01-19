package com.problems.epi.test.linked_lists;

import com.problems.epi.code.linked_lists.EvenOddMerge;
import com.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class EvenOddMergeTest {

    @Test
    public void evenOddMergeTest() {
        ListNode input = new ListNode(2);
        input.next = new ListNode(5);
        input.next.next = new ListNode(7);

        ListNode expected = input;
        ListNode tmp = input.next;
        input.next = input.next.next;
        input.next.next = tmp;
        tmp.next = null;


        ListNode actual = EvenOddMerge.evenOddMerge(input);
        //Assert.assertSame(expected, actual);
        Assert.assertEquals(expected, actual);
    }
}
