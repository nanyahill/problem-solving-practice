package com.problems.epi.test.heaps;

import com.problems.epi.code.heaps.OnlineMedian;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineMedianTest {

    @Test
    public void onlineMedianTest() {
        List<Integer> input = Arrays.asList(new Integer[] {1, 0, 3, 5, 2, 0, 1});
        Double[] expected = Arrays.asList(new Double[] {1.0, 0.5, 1.0, 2.0, 2.0, 1.5, 1.0}).toArray(new Double[0]);
        Double[] actual = OnlineMedian.onlineMedian(input.iterator()).toArray(new Double[0]);
        //Assert.assertArrayEquals(expected, actual, 1e-9);
        Assert.assertArrayEquals(expected,actual);
    }
}
