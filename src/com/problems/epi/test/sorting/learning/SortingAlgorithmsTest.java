package com.problems.epi.test.sorting.learning;

import com.problems.epi.code.sorting.learning.InsertionSort;
import com.util.ListNode;
import org.junit.Test;

public class SortingAlgorithmsTest {

    @Test
    public void insertIonSort_LinkedListTest() {
        ListNode<Integer> head = new ListNode<>(3);
        head.next = new ListNode<>(4);
        head.next.next = new ListNode<>(1);

        ListNode<Integer> expected = new ListNode<>(1);
        expected.next = new ListNode<>(3);
        expected.next.next = new ListNode<>(4);

        ListNode<Integer> actual = InsertionSort.insertionSort_LinkedList(head);
        assert(expected == actual);




    }
}
