package com.problems.epi.test.arrays;

import com.problems.epi.code.arrays.PlusOne;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nanya on 12/4/17.
 */
public class PlusOneTest {

    @Test
    public void plusOneTest() {
        int[] input = { 2, 1, 4, 7, 4, 8, 3, 6, 4, 7 };
        int[] expected = {2, 1 , 4, 7, 4, 8, 3, 6, 4, 8};
        int[] actual = PlusOne.plusOneElegant(input);
        assertArrayEquals(expected, actual);
        //Assert.assertArrayEquals(expected,actual);
    }
}
