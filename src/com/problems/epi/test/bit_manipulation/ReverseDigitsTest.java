package com.problems.epi.test.bit_manipulation;

import com.problems.epi.code.bit_manipulation.ReverseDigits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nanya on 11/14/17.
 */
public class ReverseDigitsTest {

    @Test
    public void reverseDigitsTest() {
        int actualOutput = ReverseDigits.reverseDigits(-123);
        int expectedOutput = -321;
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void reverseDigitsWithStringTest() {
        int actualOutput = ReverseDigits.reverseDigitsWithStringToo(100);
        int expectedOutput = 1;
        System.out.print(1 / 10);
        Integer.reverse(54);
        assertEquals(expectedOutput, actualOutput);
    }
}

