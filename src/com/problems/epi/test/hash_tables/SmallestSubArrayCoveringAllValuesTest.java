package com.problems.epi.test.hash_tables;

import com.problems.epi.code.hash_tables.SmallestSubArrayCoveringAllValues;
import org.junit.Test;

public class SmallestSubArrayCoveringAllValuesTest {

    @Test
    public void findSmallestSubArrayCoveringAllValues() {
        String str = "bdab";
        String ptr = "ab";
        String actual = SmallestSubArrayCoveringAllValues.findSmallestSubArrayCoveringAllValues_WithStrings(str, ptr);
        String expected = "ab";
        assert(expected.equals(actual));
    }
}
