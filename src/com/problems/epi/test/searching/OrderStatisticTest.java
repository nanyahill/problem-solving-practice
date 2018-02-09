package com.problems.epi.test.searching;

import com.problems.epi.code.searching.OrderStatistic;
import org.junit.Test;

public class OrderStatisticTest {

    @Test
    public void orderStatisticTest() {
        int[] in = {1};
        int expected = 1;
        int actual = OrderStatistic.findKthLargest(in, 1);
        assert(expected == actual);

    }
}
