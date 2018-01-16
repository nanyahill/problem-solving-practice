package com.problems.epi.test.linked_lists;

import com.problems.epi.code.linked_lists.TestOverLapping;
import com.problems.util.ListNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Nanya on 1/15/18.
 */
public class TestOverLappingTest {

    @Test
    public void detectOverLapTest() {
        ListNode<Integer> L1 = new ListNode<>(1, new ListNode<>(2));
        L1.next.next =  new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, null)));

        ListNode<Integer> L2 = new ListNode<>(5, new ListNode<>(3));
        L2.next.next =  new ListNode<>(11, new ListNode<>(9, L1.next.next));

        ListNode<Integer> expected = L1.next.next;
        ListNode<Integer> actual = TestOverLapping.detectOverLapSolution2(L1, L2);
        Assert.assertEquals(expected, actual);
    }
}
