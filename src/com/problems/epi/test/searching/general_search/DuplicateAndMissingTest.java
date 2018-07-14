package com.problems.epi.test.searching.general_search;

import com.problems.epi.code.searching.general_search.DuplicateAndMissing;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class DuplicateAndMissingTest {

    @Test
    public void duplicateAndMissing() {
        Integer[] nums = {1, 2, 4, 5, 4, 0};
        int[] expected = {4, 3};
        int[] actual = DuplicateAndMissing.findDuplicateAndMissingNumbers(Arrays.asList(nums));
        Assert.assertArrayEquals(expected, actual);
    }
}
