package com.problems.epi.test.sorting;

import com.problems.epi.code.sorting.IntersectionOfTwoSortedArrays;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoSortedArraysTest {

    @Test
    public void findIntersectionTest() {
        int[] A = {2, 4, 5, 5, 6, 6, 6, 6, 8};
        int[] B = {5,5, 5,5,6, 6,6, 6,8, 8,8, 8,8 ,8};
        int[] expected = {5, 6, 8};
        int[] actual = IntersectionOfTwoSortedArrays.findIntersection_Efficient(A, B);
        Assert.assertArrayEquals(expected, actual);
    }
}
