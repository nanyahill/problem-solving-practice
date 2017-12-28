package com.problems.leetcode.tests.arrays;

import com.problems.leetcode.arrays.DegreeOfArray;
import org.junit.Assert;
import org.junit.Test;

public class DegreeOfArrayTest {

    @Test
    public void findShortestSubArrayTest() {
        int[] input = {1,2,2,3,1,4,2};
        int expected = 6;
        int actual = DegreeOfArray.findShortestSubArray(input);
        Assert.assertEquals(expected, actual);
    }
}
