package com.problems.epi.test.bit_manipulation;

import com.problems.epi.code.bit_manipulation.Parity;
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
