package com.problems.epi.test.heaps.implementation;

import com.problems.epi.code.heaps.implementation.Heap_Old;
import org.junit.Assert;
import org.junit.Test;

public class HeapundoTest {

    @Test
    public void heapCreateTest() {
        Heap_Old<Integer> heapObject = new Heap_Old<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        Integer[] expected = { null, 9, 6, 8, 2, 5, 7 };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapInsertTest() {
        Heap_Old<Integer> heapObject = new Heap_Old<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        heapObject.insert(10);
        Integer[] expected = { null, 10, 6, 9, 2, 5, 7, 8, null, null, null, null };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapExtractMaxTest() {
        Heap_Old<Integer> heapObject = new Heap_Old<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(8 == heapObject.extractMax());
    }

    @Test
    public void heapDeleteTest() {
        Heap_Old<Integer> heapObject = new Heap_Old<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(6 == heapObject.delete(2));
    }

    @Test
    public void heapFindMaxTest() {
        Heap_Old<Integer> heapObject = new Heap_Old<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(9 == heapObject.findMax());
    }
}
