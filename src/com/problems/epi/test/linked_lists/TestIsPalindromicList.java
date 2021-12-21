package com.problems.epi.test.linked_lists;

import com.problems.epi.code.linked_lists.IsPalindromic;
import com.problems.epi.code.linked_lists.TestCyclicity;
import com.problems.epi.code.strings.TestPalindromicity;
import com.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class TestIsPalindromicList {

    @Test
    public void testPalindromicity() {
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2));
        head.next.next = new ListNode<>(2, new ListNode<>(1, null));
        boolean expected = true;

        boolean actual = IsPalindromic.isPalindrome(head);
        Assert.assertEquals(expected, actual);
    }
}
