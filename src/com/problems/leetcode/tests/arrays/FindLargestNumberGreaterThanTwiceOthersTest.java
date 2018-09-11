package com.problems.leetcode.tests.arrays;

import com.problems.leetcode.code.arrays.FindLargestNumberGreaterThanTwiceOthers;
import org.junit.Assert;
import org.junit.Test;

public class FindLargestNumberGreaterThanTwiceOthersTest {

    @Test
    public void findLargestNumberTest() {
        int[] input = {1, 0};
        int expected = -1;
        int actual = FindLargestNumberGreaterThanTwiceOthers.dominantIndexAnotherSolution(input);
        Assert.assertEquals(expected, actual);
    }
}
