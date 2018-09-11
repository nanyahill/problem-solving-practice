package com.problems.leetcode.tests.arrays;

import com.problems.leetcode.code.arrays.MaximumProductOfThreeNumbers;
import org.junit.Assert;
import org.junit.Test;

public class MaximumProductOfThreeNumbersTest {

    @Test
    public void findMaximumProductOfThreeNumbersTest() {
        int[] input = {-4, -3, -2, -1, 60};
        int expected = 720;
        int actual = MaximumProductOfThreeNumbers.findMaximumProductOfThreeNumbers(input);
        Assert.assertEquals(expected, actual);
    }
}
