package com.problems.epi.code.stacks_queues.implementation;

import java.util.NoSuchElementException;

/**
 * The implementation is good because:
 * 1. it is simple and efficient
 * The implementation is bad because:
 * 1. it relies on a fixed size capacity which limits the ultimate size of the stack.
 * Although can overcome this by using dynamic arrays (ArrayList)
 * Time Complexity: All operations are O(1)
 */
public class MyStack_UsingArray<T> {
    T[] data = null;
    int size = 0;
    int capacity = 0;

    public MyStack_UsingArray(int capacity) {
        data = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void push(T val) {
        if (size == capacity) throw new IllegalStateException("Stack is full");
        data[size++] = val;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException(); // could return null if not a valid entry
        T item = data[--size];
        data[size] = null; // for garbage collection
        return (T) item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
