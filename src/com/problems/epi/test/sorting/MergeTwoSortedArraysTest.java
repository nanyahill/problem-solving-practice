package com.problems.epi.test.sorting;

import com.problems.epi.code.sorting.MergeTwoSortedArrays;
import org.junit.Assert;
import org.junit.Test;

public class MergeTwoSortedArraysTest {

    @Test
    public void mergeTwoSortedArraysTest() {
        int[] A = {1, 2, 5, 9, 0, 6}; // focus is on {1,2,5}
        int[] B = {3, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        MergeTwoSortedArrays.mergeTwoSortedArrays_OneLinerLoop(A, 3, B, 3);
        int[] actual = A;
        Assert.assertArrayEquals(expected, actual);
    }
}
