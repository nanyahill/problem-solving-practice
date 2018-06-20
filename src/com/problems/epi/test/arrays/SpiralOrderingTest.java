package com.problems.epi.test.arrays;

import com.problems.epi.code.arrays.SpiralOrdering;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nanya on 12/21/17.
 */
public class SpiralOrderingTest {

    @Test
    public void spiralOrderingTest() {
        int[][] A1 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        int[][] A2 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        int[][] A3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expected1 = {0, 1, 2, 3, 7, 11, 15, 14, 13, 12, 8, 4, 5, 6, 10, 9};
        int[] expected2 = {0, 1, 2, 3, 7, 11, 10, 9, 8, 4, 5, 6};
        int[] expected3 = {1, 2, 3, 6, 9, 8, 7, 4 ,5};

        int[] actual = SpiralOrdering.spiralOrderMatrix(A2);
        Assert.assertArrayEquals(expected2, actual);

//        int[] actual = SpiralOrdering.spiralOrderMatrix(A3);
//        Assert.assertArrayEquals(expected3, actual);
    }
}
