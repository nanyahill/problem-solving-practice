package com.problems.epi.test.hash_tables;

import com.problems.epi.code.hash_tables.PalindromePermutation;
import org.junit.Test;

public class PalindromePermutationTest {

    @Test
    public void isPalindromePermutationTest() {
        String input = "raadr";
        boolean expected = true;
        assert(expected == PalindromePermutation.isPalindromePermutation(input));
    }

    @Test
    public void isPalindromePermutationOptimizationTest() {
        String input = "rqadr";
        boolean expected = false;
        assert(expected == PalindromePermutation.isPalindromePermutation(input));
    }
}
