package com.problems.epi.code.stacks_queues;

import java.util.NoSuchElementException;

/**
 * Circular Queues- They come about when you implement a Queue using an array.
 * Without circular queues, you run into the problem when the Queue is full (i.e. front == rear || rear == numOfElements).
 * Even though you maybe allowed to resize the array, there would be a lot of wasted space whenever a dequeue happens at the front of the Queue.
 * Hence, Circular queues help to prevent this from happening by using the formula: (i + 1) % queueCapacity where i = position of rear.
 * Time Complexity for all operations: O(1)
 */

// This class implements a circular queue.
public class Queue_WithCircularArray_NoResizing<T> {
    Object[] elements = null;
    int front = -1;
    int rear = -1;
    int capacity;
    int size = 0;

    public Queue_WithCircularArray_NoResizing(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
    }

    // front() and rear() return just the index
    public int front() { return front;}

    public int rear() { return rear;}

    public int size() { return size;}

    public boolean isEmpty() { return front == -1 && rear == -1; }

    public boolean isFull() { return rear + 1 == capacity && front == 0; } //if front == 0, no dequeue has happened

    public void enqueue(T val) {
        if(isFull()) throw new IllegalStateException("Queue is full");
        else if(isEmpty()) {
            front = rear = 0;
        }
        else {
            rear = (rear + 1) % capacity;
        }
        elements[rear] = val;
        size++;
    }

    public T dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        Object val = elements[front];
        if(front == rear) {
            front = -1;
            rear = -1;
        }
        front = (front + 1) % capacity;
        size--;
        return (T) val;
    }
}
