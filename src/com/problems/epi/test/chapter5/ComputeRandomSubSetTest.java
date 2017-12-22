package com.problems.epi.test.chapter5;

import com.problems.epi.code.chapter5.ComputeRandomSubSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nanya on 12/19/17.
 */
public class ComputeRandomSubSetTest {

    @Test
    public void computeRandomSubSetTest() {
        int n = 10;
        int k = 4;
        int expected = 4;
        Assert.assertEquals(expected, ComputeRandomSubSet.computeRandomCombinationWithHashTable(n, k).length);
    }
}
