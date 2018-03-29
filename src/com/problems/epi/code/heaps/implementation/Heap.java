package com.problems.epi.code.heaps.implementation;

import java.util.NoSuchElementException;

/**
 * This class implements a heap using an array
 * It demonstrates all the operations of a max-heap including heapsort.
 * The same idea applies for min-heap except that comparisons of keys are reversed
 */
public class Heap<T extends Comparable<T>> {

    public T[] heap = null;
    int size = 0;
    final int DEFAULT_CAPAPCITY = 10;

    public Heap(T[] array) {
        this.size = array.length;
        heap = (T[]) new Comparable[array.length + 1];
        System.arraycopy(array, 0, heap, 1, array.length);
        createMinHeap_UsingSink(heap);
    }


    public Heap() {
        size = DEFAULT_CAPAPCITY;
        heap = (T[]) new Comparable[DEFAULT_CAPAPCITY + 1];
    }

    /**
     * This method constructs a heap from an input array using the top-down (sink) heap construction
     * Notes: First element starts at index 1.
     * Parental nodes occupy the first (Math.floor(i/2)) positions of the array
     * Leaf nodes occupy the last (Math.floor(i/2)) positions of the array
     * Assume index 0 contains a sentinel
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public void createMinHeap_UsingSink(Comparable[] array) {
        if (array == null) throw new IllegalStateException();
        if (heap.length < array.length) resize();
        if(heap != array) {
            size = array.length;
            heap = (T[]) new Comparable[array.length + 1];
            System.arraycopy(array, 0, heap, 1, array.length);
        }
        int n = size, mid = n / 2;
        for (int i = mid; i > 0; i--) sink(i);
    }

    /**
     * This method constructs a heap from an input array using the bottom-up (swim) heap construction
     * The construction can be imagines as successive heap insertions
     * It is less efficient than the sink method above
     * Why is it less efficient? Nodes at the bottom travel a longer distance up the tree than nodes at the top.
     * Time complexity: O(nlogn)
     * Space Complexity: O(1)
     */
    public void createMinHeap_UsingSwim(Comparable[] array) {
        if (array == null) throw new IllegalStateException();
        if (heap.length < array.length) resize();
        if(heap != array) {
            size = array.length;
            heap = (T[]) new Comparable[array.length + 1];
            System.arraycopy(array, 0, heap, 1, array.length);
        }
        for (int i = size; i > 0; i--) swim(i);
    }

    public void resize() {
        T[] old = heap;
        heap = (T[]) new Comparable[size * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public void insert(T val) {
        if (size == heap.length - 1) resize();
        heap[++size] = val;
        swim(size);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public T delete(int index) {
        T toDelete = heap[index];
        swap(heap, index, size--);
        sink(index);
        heap[size + 1] = null;
        return toDelete;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * Note: Finding an arbitrary element takes O(n)
     */
    public T findMin() {
        if (size == 0) throw new NoSuchElementException();
        return heap[1];
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public T extractMin() {
        if (size == 0) throw new NoSuchElementException();
        T min = heap[1];
        swap(heap, 1, size--);
        sink(1);
        return min;
    }

    /***************************************
     * Helper Functions
     ***************************************/

    /**
     * Time Complexity: O(logn)
     * Note: when used in heap construction, this time complexity for the construction is different
     * because of the sum for each swim up the tree
     * Space Complexity: O(1)
     */
    // Think of this method as swimming from the bottom to top (bottom-up)
    private void swim(int k) {
        while (k > 1 && heap[k].compareTo(heap[k / 2]) < 0) {
            swap(heap, k, k / 2);
            k /= 2;
        }
    }

    /**
     * Time Complexity: O(logn)
     * Note: when used in heap construction, the time complexity for the construction is different
     * because of the sum for each sink down the tree
     * Space Complexity: O(1)
     */
    // Think of this method as sinking from the top to bottom (top-down)
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j].compareTo(heap[j + 1]) > 0) j++;
            if (heap[k].compareTo(heap[j]) < 0) break;
            swap(heap, k, j);
            k = j;
        }
    }

    private void swap(T[] A, int i, int j) {
        T tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
