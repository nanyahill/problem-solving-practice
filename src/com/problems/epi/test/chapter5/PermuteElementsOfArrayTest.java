package com.problems.epi.test.chapter5;

import com.problems.epi.code.chapter5.PermuteElementsOfArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nanya on 12/8/17.
 */
public class PermuteElementsOfArrayTest {

    @Test
    public void permuteElementsOfArrayTest() {
        char arr[] = new char[]{'a','b','c', 'd', 'e'};
        int index[] = new int[]{3, 1, 4, 0, 2};

        char[] expected = {'d', 'b', 'e', 'a', 'c'};
        PermuteElementsOfArray.applyPermutation(arr, index);
        assertArrayEquals(expected, arr);
        //System.out.print(Arrays.asList(PermuteElementsOfArray.premuteArray(P, A)));
    }
}
