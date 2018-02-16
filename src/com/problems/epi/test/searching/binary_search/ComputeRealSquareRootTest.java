package com.problems.epi.test.searching.binary_search;

import com.problems.epi.code.searching.binary_search.ComputeRealSquareRoot;
import org.junit.Test;

public class ComputeRealSquareRootTest {

    @Test
    public void computeRealSquareRoot() {
        double actual = ComputeRealSquareRoot.computeRealSquareRoot(0.5);
        double expected = Math.sqrt(0.5);
        assert(ComputeRealSquareRoot.compare(actual,expected) == ComputeRealSquareRoot.Ordering.EQUAL);
    }
}
