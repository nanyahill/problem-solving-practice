package com.problems.epi.test.strings;

import com.problems.epi.code.strings.TestPalindromicity;
import org.junit.Assert;
import org.junit.Test;

public class TestPalindromicityTest {

    @Test
    public void isPalindromeTest() {
        String input = "r---a--dar--";
        boolean expected = true;
        boolean actual = TestPalindromicity.isPlaindrome(input);
        Assert.assertEquals(expected, actual);
    }
}
