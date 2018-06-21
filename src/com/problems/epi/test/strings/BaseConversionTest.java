package com.problems.epi.test.strings;

import com.problems.epi.code.strings.BaseConversion;
import org.junit.Assert;
import org.junit.Test;

public class BaseConversionTest {

    @Test
    public void convertBaseTest() {
        String input = "0";
        int b1 = 7;
        int b2 = 13;
        String expected = "-10000000000000000000000000000000";
        String actual = BaseConversion.convertBase(input, b1, b2);
        Assert.assertEquals(expected, actual);
    }
}
