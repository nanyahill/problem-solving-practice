package com.problems.epi.test.sorting.learning;

import com.problems.epi.code.sorting.learning.MergeSort;
import com.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SortingAlgorithmsTest {

    @Test
    public void insertIonSort_LinkedListTest() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(3);
        head.next.next = new ListNode<>(4);
        head.next.next.next = new ListNode<>(5);
        head.next.next.next.next = new ListNode<>(7);
        head.next.next.next.next.next = new ListNode<>(2);

        ListNode<Integer> expected = new ListNode<>(1);
        expected.next = new ListNode<>(3);
        expected.next.next = new ListNode<>(4);

        //ListNode<Integer> actual = InsertionSort.insertionSort_LinkedList(head);
        //assert(expected == actual);
    }

    @Test
    public void mergeSort_Recursive_WithArrays() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual  = MergeSort.mergeSort_Recursive_WithArrays(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort_Iterative_WithArrays() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual  = MergeSort.mergeSort_Iterative_WithArrays(input);
        Assert.assertArrayEquals(expected, actual);
    }
}
