package com.problems.epi.code.heaps.implementation;

import java.util.NoSuchElementException;

/**
 * This class implements a heap using an array
 * It demonstrates all the operations of a max-heap including heapsort.
 * The same idea applies for min-heap except that comparisons of keys are reversed
 * TODO: Implement HeapSort
 */
public class Heap<T extends Comparable<T>> {

    public T[] heap = null;
    int size = 0;
    final int DEFAULT_CAPAPCITY = 2;

    public Heap(T[] array) {
        this.size = array.length;
        heap = (T[]) new Comparable[array.length + 1];
        System.arraycopy(array, 0, heap, 1, array.length);
        createMaxHeap();
    }

    public Heap() {
        heap = (T[]) new Comparable[DEFAULT_CAPAPCITY];
    }

    public void doubleSize() {
        T[] old = heap;
        heap = (T[]) new Comparable[size * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }

    /**
     * This method constructs a heap from an input array using the bottom-up heap construction
     * Notes: First element starts at index 1.
     *        Parental nodes occupy the first (Math.floor(i/2)) positions of the array
     *        Leaf nodes occupy the last (Math.floor(i/2)) positions of the array
     *        Assume index 0 contains a sentinel (-1 is used here)
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public void createMaxHeap() {
        if (heap == null || size == 0) throw new IllegalStateException();
        int n = size, mid = n / 2;
        for (int i = mid; i > 0; i--) {
            int k = i;
            T val = heap[i];
            boolean isHeap = false;
            while (!isHeap && (2 * k) <= n) {
                int j = 2 * k;
                if (j + 1 < n) {
                    if (heap[j].compareTo(heap[j + 1]) < 0) j = j + 1;
                }
                if (val.compareTo(heap[j]) >= 0) isHeap = true;
                else {
                    heap[k] = heap[j];
                    k = j;
                }
            }
            heap[k] = val;
        }
    }

    public void createMinHeap() {
        if (heap == null || size == 0) throw new IllegalStateException();
        int n = size, mid = n / 2;
        for (int i = mid; i > 0; i--) {
            int k = i;
            T val = heap[i];
            boolean isHeap = false;
            while (!isHeap && (2 * k) <= n) {
                int j = 2 * k;
                if (j + 1 < n) {
                    if (heap[j].compareTo(heap[j + 1]) > 0) j = j + 1;
                }
                if (val.compareTo(heap[j]) <= 0) isHeap = true;
                else {
                    heap[k] = heap[j];
                    k = j;
                }
            }
            heap[k] = val;
        }
    }

    public void insert(T newVal) {
        if (size == heap.length - 1) doubleSize();
        // Step 1: Insert the element to the end of the array
        int k = ++size;
        int p = k / 2;
        // Step 2: Check if it obeys the parental heap property:
        // Max heap parental property: The key of a root node of a subtree is greater than its children
        // Min heap parental property: The key of a root node of a subtree is less than its children
        while (p > 1 && newVal.compareTo(heap[p]) > 0) {
            heap[k] = heap[p];
            k = p;
            p = p / 2;
        }
        heap[k] = heap[p];
        heap[p] = newVal;
    }

    // Index is the index of the element to be deleted in the array
    public T delete(int index) {
        if (size == 0 || index <= 0) throw new NoSuchElementException();

        T toDelete = heap[index];
        // Step 1: Swap toDelete with the last element in the array
        heap[index] = heap[size];
        heap[size] = toDelete;

        // Step2: Decrease the size
        size--;

        // Step 3: Fix the heap
        createMaxHeap();
        return toDelete;
    }

    public T extractMax() {
        if (size == 0) throw new NoSuchElementException();
        // Step 1: Swap the root with the last element
        T root = heap[1];
        heap[1] = heap[size];
        heap[size] = root;
        // Step 2: Decrease the size of the heap
        size--;
        // Step 3: fix the heap
        createMaxHeap();
        return heap[1];
    }

    public T findMax() {
        if (size == 0) throw new NoSuchElementException();
        return heap[1];
    }
}
