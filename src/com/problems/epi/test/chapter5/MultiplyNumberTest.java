package com.problems.epi.test.chapter5;

import com.problems.epi.code.chapter5.MultiplyNumbers;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nanya on 12/5/17.
 */
public class MultiplyNumberTest {

    @Test
    public void multiplyNumbersTest() {
        int[] A = { 5, 6, 9, 8, 7 };
        int[] B = { 9, 9, 9, 9 };
        int[] expected = { 5, 6, 9, 8, 1, 3, 0, 1, 3 };
        int[] actual = MultiplyNumbers.multiplyTwoNumbers(A, B);
        assertArrayEquals(expected, actual);
    }
}
