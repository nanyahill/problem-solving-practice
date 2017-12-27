package com.problems.epi.test.arrays;

import com.problems.epi.code.arrays.EnumerateAllPrimes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nanya on 12/8/17.
 */
public class EnumerateAllPrimesTest {

    @Test
    public void enumerateAllPrimesTest() {
        int input = 100000;
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17));
        List<Integer> actual = EnumerateAllPrimes.enumerateAllPrimes(input);
        //assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
