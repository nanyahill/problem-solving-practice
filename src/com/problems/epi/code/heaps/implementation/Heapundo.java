package com.problems.epi.code.heaps.implementation;

import java.util.NoSuchElementException;

/**
 * This class implements a heap using an array
 * It demonstrates all the operations of a max-heap including heapsort.
 * The same idea applies for min-heap except that comparisons of keys are reversed
 */
public class Heapundo<T extends Comparable<T>> {

    public T[] heap = null;
    int size = 0;
    final int DEFAULT_CAPAPCITY = 2;

    public Heapundo(T[] array) {
        this.size = array.length;
        heap = (T[]) new Comparable[array.length + 1];
        System.arraycopy(array, 0, heap, 1, array.length);
        //createMinHeap();
    }

    /**
     * This method constructs a heap from an input array using the top-down (sink) heap construction
     * Notes: First element starts at index 1.
     *        Parental nodes occupy the first (Math.floor(i/2)) positions of the array
     *        Leaf nodes occupy the last (Math.floor(i/2)) positions of the array
     *        Assume index 0 contains a sentinel
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public void createMaxHeap() {
        if (heap == null || size == 0) throw new IllegalStateException();
        int n = size, mid = n / 2;
        for(int i = mid; i > 0; i++) sink(i);
    }

    public Heapundo() {
        heap = (T[]) new Comparable[DEFAULT_CAPAPCITY];
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
        if(size == heap.length - 1) resize();
        heap[++size] = val;
        swim(size);
    }

    /**
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public void delete(T val) {
        for(int i = 1; i <= size; i++) {
            if(heap[i].compareTo(val) == 0) sink(i);
        }
        size--;
    }

    public T findMin() {
        if(size == 0) throw new NoSuchElementException();
        return heap[1];
    }

    public T extractMin() {
        if(size == 0) throw new NoSuchElementException();
        T min = heap[1];
        swap(heap, 1, size--);
        sink(1);
        return min;
    }

    // Think of swimming from the bottom-up
    private void swim(int k) {
        while(k > 1 && heap[k].compareTo(heap[k/2]) < 0) {
            swap(heap, k, k/2);
            k /= 2;
        }
    }

    // Think of sinking from the top-down
    private void sink(int k) {
        while(2*k <= size) {
            int j = 2*k;
            if(heap[j].compareTo(heap[j+1]) > 0) j++;
            if(heap[k].compareTo(heap[j]) < 0) break;
            swap(heap, k, j);
            k = j;
        }
    }

    private void swap(T[] A, int i, int j) {
        T tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    // swim(int k)
    // sink(int k)
    // insert(int val)
    // delete(int val)
    // extractMin()
    // findMin()
    // heapSort(int[] A)
}
