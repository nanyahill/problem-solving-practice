package com.problems.epi.test.heaps;

import com.problems.epi.code.heaps.SortApproximatelySorted;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SortApproximatelySortedTest {

    @Test
    public void sortApproximatelySorted_HeapTest() {
        List<Integer> input = Arrays.asList(new Integer[] {3, -1, 2, 6, 4, 5, 8});
        Integer[] expected = {-1, 2, 3, 4, 5, 6, 8};
        Integer[] actual = SortApproximatelySorted.sortAlmostSorted_Heap(input, 2).toArray(new Integer[0]);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortApproximatelySorted_InsertionSortTest() {
        List<Integer> input = Arrays.asList(new Integer[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9});
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] actual = SortApproximatelySorted.sortAlmostSorted_InsertionSort(input, 4).toArray(new Integer[0]);
        Assert.assertArrayEquals(expected, actual);
    }
}
