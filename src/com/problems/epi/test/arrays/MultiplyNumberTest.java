package com.problems.epi.test.arrays;

import com.problems.epi.code.arrays.MultiplyNumbers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nanya on 12/5/17.
 */
public class MultiplyNumberTest {

    @Test
    public void multiplyNumbersTest() {
        Integer[] A = { 5, 6, 9, 8, 7 };
        Integer[] B = { 9, 9, 9, 9 };
        Integer[] expected = { 5, 6, 9, 8, 1, 3, 0, 1, 3 };
        List<Integer> actualList = MultiplyNumbers.multiplyTwoNumbers(Arrays.asList(A), Arrays.asList(B));
        Integer[] actual = actualList.toArray(new Integer[0]);
        assertArrayEquals(expected, actual);
    }
}
