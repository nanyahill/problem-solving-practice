package com.problems.epi.test.arrays;

import com.problems.epi.code.arrays.RemoveDuplicatesFromSortedArray;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nanya on 12/6/17.
 */
public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void removeDuplicatesFromSortedArrayTest() {
        int[] input = { 2, 3, 5, 5, 7, 11, 11, 11, 13};
        int expected = 6;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicatesFromSortedArray_Efficient(input);
        assertEquals(expected, actual);
    }
}
