package com.problems.epi.test.strings;

import com.problems.epi.code.strings.ReplaceAndRemove;
import org.junit.Assert;
import org.junit.Test;

public class ReplaceAndRemoveTest {

    @Test
    public void replaceAndRemoveTest() {
        char[] input = {'a', ' '};
        char[] expected = {'d', 'd'};
        char[] actual = ReplaceAndRemove.replaceAndRemove(input, 1);
        Assert.assertArrayEquals(expected, actual);
    }
}
