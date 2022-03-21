package com.problems.epi.test.searching.general_search;

import com.problems.epi.code.searching.general_search.OrderStatistic;
import org.junit.Assert;
import org.junit.Test;

public class OrderStatisticTest {

    @Test
    public void orderStatisticTest() {
        int[] in = {3, 2, 1, 5, 6, 4};
        int expected = 1;
        int actual = OrderStatistic.findKthLargest(in, 6);
        //Assert.assertTrue(expected == actual);
        assert(expected == actual);
        System.out.println(1 << 16);
    }

    @Test
    public void partitionWithDnFTest() {
        int[] in = {5, 1, 7, 3, 4, 6};
        int expected = 1;
        int actual = OrderStatistic.partition(in, 0, 5);
        //Assert.assertTrue(expected == actual);
        assert(expected == actual);
        System.out.println(1 << 16);
    }
}
