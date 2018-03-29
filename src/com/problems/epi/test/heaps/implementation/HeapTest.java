package com.problems.epi.test.heaps.implementation;

import com.problems.epi.code.heaps.implementation.Heap;
import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

    @Test
    public void heapCreateTest_UsingSink() {
        Heap<Integer> heapObject = new Heap<>();
        heapObject.createMinHeap_UsingSink(new Comparable[] { 2, 9, 7, 6, 5, 8 });
        Integer[] expected = { null, 2, 5, 7, 6, 9, 8 };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapCreateTest_UsingSwim() {
        Heap<Integer> heapObject = new Heap<>();
        heapObject.createMinHeap_UsingSwim(new Comparable[] { 2, 9, 7, 6, 5, 8 });
        Integer[] expected = { null, 2, 5, 7, 6, 9, 8 };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapInsertTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        heapObject.insert(10);
        // extra nulls because of resizing that happens in insert function
        Integer[] expected = { null, 2, 5, 7, 6, 9, 8, 10, null, null, null, null };
        Assert.assertArrayEquals(expected, heapObject.heap);
    }

    @Test
    public void heapExtractMinTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(2 == heapObject.extractMin());
    }

    @Test
    public void heapDeleteTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        Integer actual = heapObject.delete(2);
        assert(5 == actual);
    }

    @Test
    public void heapFindMinTest() {
        Heap<Integer> heapObject = new Heap<>(new Integer[] { 2, 9, 7, 6, 5, 8 });
        assert(2 == heapObject.findMin());
    }
}
