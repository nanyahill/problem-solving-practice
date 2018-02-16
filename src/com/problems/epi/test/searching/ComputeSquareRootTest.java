package com.problems.epi.test.searching;

import com.problems.epi.code.searching.binary_search.ComputeSquareRoot;
import org.junit.Test;

public class ComputeSquareRootTest {

    @Test
    public void computeSquareRootTest() {
        int num = 23;
        long expected = 4;
        long actual = ComputeSquareRoot.computeSquareRoot_BrutForce(num);
        assert(expected == actual);
    }
}
