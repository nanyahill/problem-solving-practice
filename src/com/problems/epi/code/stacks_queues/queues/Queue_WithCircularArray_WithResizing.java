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
    public Integer[] data;
    public int size, front = 0, rear = 0;
    public int capacity;

    public Queue_WithCircularArray_WithResizing(int capacity) {
        data = new Integer[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Integer val) {
        if (size == capacity) { // full
            // Makes queue elements appear consecutively
            // This will make the front point to the first element
            // -ve number rotate array to the left by a distance = front
            // Ref: https://laasyasettyblog.hashnode.dev/juggling-algorithm-for-array-rotation
            Collections.rotate(Arrays.asList(data), -front);
            front = 0;
            rear = size;
            data = Arrays.copyOf(data, capacity * 2);
            capacity = data.length;
        }
        data[rear] = val;
        rear = (rear + 1) % capacity;
        size++;
    }

    public Integer dequeue() {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty!");
        Integer valToDelete = data[front];
        front = (front + 1) % capacity;
        size--;
        return valToDelete;
    }
}
