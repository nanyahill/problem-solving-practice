package com.problems.epi.test.strings;

import com.problems.epi.code.strings.ReplaceAndRemove;
import org.junit.Assert;
import org.junit.Test;

public class ReplaceAndRemoveTest {

    @Test
    public void replaceAndRemoveTest() {
        char[] input = {'a', ' '};
        int expected = 2;
        int actual = ReplaceAndRemove.replaceAndRemove(input, 1);
        Assert.assertEquals(expected, actual);
    }
}
