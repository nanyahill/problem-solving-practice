package com.problems.epi.code.stacks_queues.implementation;

import java.util.NoSuchElementException;

/**
 * This implementation is useful when the queue size is less than the capacity most of the time.
 * A normal array cannot be used because:
 * 1. It has fixed size (cannot be resized)
 * 2. It wastes space if the queue size less than its capapcity most of the time
 * Time Complexity: All operations are O(1)
 */
public class MyQueue_UsingCircularArray<T> {
    Object[] elements = null;
    int front = -1;
    int rear = -1;
    int capacity;
    int size = 0;

    public MyQueue_UsingCircularArray(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
    }

    // front() and rear() return just the index
    public int front() {
        return front;
    }

    public int rear() {
        return rear;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear + 1 == capacity && front == 0;
    } //if front == 0, no dequeue has happened

    public void enqueue(T val) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        else if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        elements[rear] = val;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Object val = elements[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        front = (front + 1) % capacity;
        size--;
        return (T) val;
    }
}
