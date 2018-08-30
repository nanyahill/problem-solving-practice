package com.problems.epi.test.hash_tables;

import com.problems.epi.code.hash_tables.SmallestSubArrayCoveringSet;
import org.junit.Test;

public class SmallestSubArrayCoveringSetTest {

    @Test
    public void findSmallestSubArrayCoveringAllValues() {
        String str = "bdab";
        String ptr = "ab";
        String actual = SmallestSubArrayCoveringSet.findSmallestSubArrayCoveringAllValues_WithStrings(str, ptr);
        String expected = "ab";
        assert(expected.equals(actual));
    }
}
