package com.problems.epi.test.searching.binary_search;

import com.problems.epi.code.searching.binary_search.SearchCyclicallySorted;
import org.junit.Test;

public class SearchCyclicallySortedTest {

    @Test
    public void findMinTest() {
        int[] in = {378, 478, 550, 678, 102, 112, 234};
        int expected = 4;
        int actual = SearchCyclicallySorted.findMinimumElementIndex_Distinct(in);
        assert(expected == actual);
        System.out.println(actual);
    }

    @Test
    public void findMaxTest() {
        int[] in = {378, 478, 550, 678, 102, 112, 234};
        int expected = 3;
        int actual = 3;//SearchCyclicallySorted.findMax(in);
        assert(expected == actual);
        System.out.println(actual);
    }

    @Test
    public void findKTest() {
        int[] in = {378, 478, 550, 678, 102, 112, 234};
        int expected = 1;
        int actual = SearchCyclicallySorted.findElementIndex_Distinct(in, 478);
        assert(expected == actual);
        System.out.println(actual);
    }
}
