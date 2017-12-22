package com.problems.epi.test.chapter4;

import com.problems.epi.code.chapter4.PowerOfX;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nanya on 11/13/17.
 */
public class PowerOfXTest {

    double epsilon = 1.0e-6;

    @Test
    public void powerTest() {
        double actualOutput = PowerOfX.powerOfXIterative(2, -3);
        double expectedOutput = 0.25;
        System.out.print(-1 / 10);
        assertEquals(expectedOutput, actualOutput, epsilon);
    }
}
