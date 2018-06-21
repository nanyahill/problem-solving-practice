package com.problems.epi.test.strings;

import com.problems.epi.code.strings.InterConvertStringsAndArrays;
import org.junit.Assert;
import org.junit.Test;

public class InterConvertStringsAndArraysTest {

    @Test
    public void parseIntTest() {
        String input = "-123";
        int expected = -123;
        int actual = InterConvertStringsAndArrays.stringToInt(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        int input = 123;
        String expected = "123";
        String actual = InterConvertStringsAndArrays.intToString(input);
        Assert.assertEquals(expected, actual);
    }
}

