package com.problems.epi.test.chapter5;

import com.problems.epi.code.chapter5.RemoveDuplicatesFromSortedArray;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nanya on 12/6/17.
 */
public class RemveDuplicatesFromSortedArrayTest {

    @Test
    public void removeDuplicatesFromSortedArrayTest() {
        int[] input = {2, 3, 3, 5, 5};
        int expected = 3;
        int actual = RemoveDuplicatesFromSortedArray.removeDuplicatesFromSortedArray2(input);
        assertEquals(expected, actual);
    }
}
