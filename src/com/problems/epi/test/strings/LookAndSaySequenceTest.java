package com.problems.epi.test.strings;

import com.problems.epi.code.strings.LookAndSaySequence;
import org.junit.Assert;
import org.junit.Test;

public class LookAndSaySequenceTest {

    @Test
    public void lookAndSayTest() {
        int input = 7;
        String expected = "13112221";
        String actual = LookAndSaySequence.lookAndSay(input);
        Assert.assertEquals(expected, actual);
    }
}
