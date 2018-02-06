package com.problems.epi.test.heaps;

import com.problems.epi.code.heaps.MergeKSortedLists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedListsTest {

    @Test
    public void mergeKSortedListsTest() {
        Integer[][] arrays = new Integer[][] {{3, 5, 7}, {0, 6}, {0, 6, 28}};
        List<List<Integer>> sortedLists = new ArrayList<>();
        for(Integer[] array : arrays) sortedLists.add(Arrays.asList(array));
        List<Integer> expected = Arrays.asList(0, 0, 3, 5, 6, 6, 7,28);
        List<Integer> actual = MergeKSortedLists.mergeKSortedLists(sortedLists);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
