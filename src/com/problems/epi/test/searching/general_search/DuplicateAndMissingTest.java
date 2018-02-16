package com.problems.epi.test.searching.general_search;

import com.problems.epi.code.searching.general_search.DuplicateAndMissing;
import org.junit.Assert;
import org.junit.Test;

public class DuplicateAndMissingTest {

    @Test
    public void duplicateAndMissing() {
        int[] nums = {1, 2, 4, 5, 4, 0};
        int[] expected = {4, 3};
        int[] actual = DuplicateAndMissing.findDuplicateAndMissingNumbers(nums);
        Assert.assertArrayEquals(expected, actual);
    }
}
