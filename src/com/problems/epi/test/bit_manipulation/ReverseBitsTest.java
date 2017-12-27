package com.problems.epi.test.bit_manipulation;

import com.problems.epi.code.bit_manipulation.ReverseBits;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Nanya on 11/9/17.
 */
public class ReverseBitsTest {
    ReverseBits rB;

    @Before
    public void init() {
        rB = new ReverseBits();
    }

    @Test
    public void buildLookUpTableTest() {
        int[] actualOutput = rB.buildLookUpTable();
        int[] expectedOutput = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void reverseBitsTest() {
        long actualOutput = rB.reverseBitsIterative(1);
        assertEquals(2147483648l, actualOutput);
    }


}
