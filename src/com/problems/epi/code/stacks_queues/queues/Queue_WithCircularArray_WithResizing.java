package com.problems.epi.code.stacks_queues.queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Circular Queues- They come about when you implement a Queue using an array.
 * Without circular queues, you run into the problem when the Queue is full (i.e. front == rear || rear == numOfElements).
 * Even though you maybe allowed to resize the array, there would be a lot of wasted space whenever a dequeue happens at the front of the Queue.
 * Hence, Circular queues help to prevent this from happening by using the formula: (i + 1) % queueCapacity where i = position of rear.
 * Time Complexity for all operations: O(1)
 */

// This class allows the array to be resized. In essence, it isn't really a circular queue.
// It just uses the concept of circular queue implementation
public class Queue_WithCircularArray_WithResizing<T> {
    Object[] elements = null;
    int front = -1;
    int rear = -1;
    int capacity;
    int size;

    public Queue_WithCircularArray_WithResizing(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return rear + 1 == capacity;
    }

    public void enqueue(T val) {
        if (isFull()) {
            // Rotate array so the elements appear consecutively
            // This is need when front is no longer 0
            // If this isn't done, enqueue will overwrite elements
            Collections.rotate(Arrays.asList(elements), -front);
            //Reset front and rear
            front = 0;
            rear = size;
            elements = Arrays.copyOf(elements, capacity * 2);
            capacity = elements.length;
        } else if (isEmpty()) {
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
        if (front == rear) { // Last element in the queue
            front = -1;
            rear = -1;
        }
        front = (front + 1) % capacity;
        size--;
        return (T) val;
    }
}
