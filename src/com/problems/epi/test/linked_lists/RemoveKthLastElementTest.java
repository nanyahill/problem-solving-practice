package com.problems.epi.test.linked_lists;

import com.problems.epi.code.linked_lists.RemoveKthLastElement;
import com.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class RemoveKthLastElementTest {

    @Test
    public void removeKthToLastTest() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);

        ListNode<Integer> expected = l1;
        expected.next = expected.next.next;

        ListNode<Integer> actual = RemoveKthLastElement.removeKthToLast(l1, 2);

        Assert.assertEquals(expected, actual);
    }
}
