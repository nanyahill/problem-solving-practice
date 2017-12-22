package com.problems.epi.test.chapter4;

import com.problems.epi.code.chapter4.Parity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nanya on 11/8/17.
 */
public class ParityTest {
    Parity parity;

    @Before
    public void init() {
        parity = new Parity();
    }

    @Test
    public void computeParityTest() {
        short actualOutput = parity.computeParity(0);
        assertEquals(0, actualOutput);
    }

}
