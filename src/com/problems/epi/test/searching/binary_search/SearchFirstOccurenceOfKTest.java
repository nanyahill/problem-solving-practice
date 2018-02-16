package com.problems.epi.test.searching.binary_search;

import com.problems.epi.code.searching.binary_search.SearchFirstOccurenceOfK;
import org.junit.Test;

public class SearchFirstOccurenceOfKTest {

    @Test
    public void searchFirstOccurenceOfKTest() {
        int[] input = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        int expected = 3;
        int actual = SearchFirstOccurenceOfK.searchFirstOccurenceOfK(input, 108);
        assert(expected == actual);
    }
}
