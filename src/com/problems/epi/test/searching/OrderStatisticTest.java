package com.problems.epi.test.searching;

import com.problems.epi.code.searching.OrderStatistic;
import org.junit.Test;

public class OrderStatisticTest {

    @Test
    public void orderStatisticTest() {
        Comparable[] in = {3, 2, 1, 5, 6, 4};
        Comparable expected = 1;
        Comparable actual = OrderStatistic.findKthLargest(in, 6);
        assert(expected.compareTo(actual) == 0);
    }
}
