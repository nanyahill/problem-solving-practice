package com.problems.epi.test.heaps.implementation;

import com.problems.epi.code.heaps.implementation.Heap;
import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

    @Test
    public void heapCreateTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        Integer[] expected = { null, 9, 6, 8, 2, 5, 7 };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapInsertTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        heapObject.insert(10);
        Integer[] expected = { null, 10, 6, 9, 2, 5, 7, 8, null, null, null, null };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapExtractMaxTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(8 == heapObject.extractMax());
    }

    @Test
    public void heapDeleteTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(6 == heapObject.delete(2));
    }

    @Test
    public void heapFindMaxTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(9 == heapObject.findMax());
    }
}
