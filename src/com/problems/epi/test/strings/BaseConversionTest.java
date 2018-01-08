package com.problems.epi.test.strings;

import com.problems.epi.code.strings.BaseConversion;
import org.junit.Assert;
import org.junit.Test;

public class BaseConversionTest {

    @Test
    public void convertBaseTest() {
        String input = "-2147483648";
        int b1 = 10;
        int b2 = 2;
        String expected = "-10000000000000000000000000000000";
        String actual = BaseConversion.convertBase(input, b1, b2);
        Assert.assertEquals(expected, actual);
    }
}
