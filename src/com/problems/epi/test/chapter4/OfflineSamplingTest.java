package com.problems.epi.test.chapter4;

import com.problems.epi.code.chapter5.OfflineSampling;
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