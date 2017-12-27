package com.problems.epi.test.bit_manipulation;

import com.problems.epi.code.arrays.OfflineSampling;
import org.junit.Test;

/**
 * Created by Nanya on 12/19/17.
 */
public class OfflineSamplingTest {

    @Test
    public void offlineSamplingTest() {
        int[] input = { 3, 23, 7, 66, 5, 1, 9 };
        int k = 3;
        //int expected = 3;
        OfflineSampling.randomSampling(input, k);
    }
}