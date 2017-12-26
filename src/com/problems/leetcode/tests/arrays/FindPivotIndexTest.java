package com.problems.leetcode.tests.arrays;

import com.problems.leetcode.arrays.FindPivotIndex;
import org.junit.Assert;
import org.junit.Test;

public class FindPivotIndexTest {
    @Test
    public void findPivotIndexTest() {
        int[] input = {1, 7, 3, 6, 5, 6};
        int expected = 3;
        int actual = FindPivotIndex.findPivotIndex(input);
        Assert.assertEquals(expected, actual);
    }
}
