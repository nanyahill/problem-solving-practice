package com.problems.epi.test.strings;

import com.problems.epi.code.strings.PhoneNumberMnemonics;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PhoneNumberMnemonicsTest {

    @Test
    public void phoneMnemonicsTest() {
        String input = "23";
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = PhoneNumberMnemonics.phoneMnemonic(input);
        Assert.assertArrayEquals(expected.toArray(new String[0]), actual.toArray(new String[0]));

    }
}
