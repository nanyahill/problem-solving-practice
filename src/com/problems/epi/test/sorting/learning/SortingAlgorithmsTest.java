package com.problems.epi.test.sorting.learning;

import com.problems.epi.code.sorting.learning.*;
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
    public void insertionSort_ArraysTest() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual  = InsertionSort.insertionSort_Arrays(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort_Recursive_WithArraysTest() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual  = MergeSort.mergeSort_Recursive_WithArrays(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort_Iterative_WithArraysTest() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual  = MergeSort.mergeSort_Iterative_WithArrays(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void quickSort_RecursiveTest() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual  = QuickSort.quickSort_Recursive_WithArrays(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void quickSort_ThreeWayTest() {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] input2 = {1, 9, 8, 17, 6, 15, 4, 3, 2, 1};
        //int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected = {1, 1, 2, 3, 4, 6, 8, 9, 15, 17 };
        int[] actual  = QuickSort.quickSort_ThreeWay(input2);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void quickSort_DualPivotTest() {
        int[] input = {2, 2, 2, 2};
        int[] expected = {2, 2, 2, 2};
        int[] actual  = QuickSort.quickSort_DualPivot(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void heapSort() {
        int[] input = {1, 9, 8, 17, 6, 15, 4, 3, 2, 1};
        int[] expected = {1, 1, 2, 3, 4, 6, 8, 9, 15, 17 };
        int[] actual  = HeapSort.heapSort(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shellSort() {
        int[] input = {1, 9, 8, 17, 6, 15, 4, 3, 2, 1};
        int[] expected = {1, 1, 2, 3, 4, 6, 8, 9, 15, 17 };
        int[] actual  = ShellSort.shellSort(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void countingSort() {
        int[] input = { -5, -2, 9, 0, -1, 2, 3, 5, -4, 6, 8 };
        int[] expected = { -5, -4, -2, -1, 0, 2, 3, 5, 6, 8, 9 };
        int[] actual  = CountingSort.countingSort(input, -5, 9);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void countingSortSedgewick() {
        int[] input = { -5, -2, 9, 0, -1, 2, 3, 5, -4, 6, 8 };
        int[] expected = { -5, -4, -2, -1, 0, 2, 3, 5, 6, 8, 9 };
        int[] actual  = CountingSort.countingSortSedgewick(input, -5, 9);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void countingSort_Alternative() {
        int[] input = { 9, 4, 1, 7, 9, 1, 2, 0, 1, 0, 3 };
        int[] expected = { 0, 0, 1, 1, 1, 2, 3, 4, 7, 9, 9 };
        //int[] actual  = CountingSort.countingSort_Alternative(input, 0, 9);
        int[] actual  = CountingSort.countingSortSedgewick(input, -5, 9);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void radixSort() {
        //String[] s = {"a", "aa", "ab", "abc", "d", "qq", "ff"};
        String[] a = { "she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"  };
        String[] expected = { "are", "by", "sea", "seashells", "seashells", "sells", "sells", "she", "she", "shells", "shore", "surely", "the", "the" };
        RadixSort.MSDRadixSort(a);
        Assert.assertArrayEquals(a, expected);
    }
}
