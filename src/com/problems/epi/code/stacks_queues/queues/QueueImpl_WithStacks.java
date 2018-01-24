package com.problems.epi.code.stacks_queues.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Key Insight: In a Queue, insertions happen at the back while deletions happen at the front.
 * In a stack, insertions and deleteions (the back and front in a queue) happen at the top of the stack.
 * Hence, use two stacks- one to enqueue (acting as the back of the queue) and the other to dequeue (acting as the front of the queue).
 * In this way, popping elements from one stack and pushing to another stack reverses the order of the elements.
 * Note that some dequeue operations may take O(n) but this complexity is amortized over time because it rarely happens. Hence, enqueque and dequeue take O(1) overall.
 * Time complexity for all operations: O(1)
 * Space Complexity: O(n)
 */
public class QueueImpl_WithStacks<T> {

    Deque<T> s1 = new ArrayDeque<>();
    Deque<T> s2 = new ArrayDeque<>();
    T front;

    public void enqueue(T val) {
        if (s1.isEmpty()) front = val;
        s1.push(val);
    }

    public T dequeue() {
        if (s2.isEmpty()) {
            if (populateS2()) {
                Object valToDelete = s2.pop();
                return (T) valToDelete;
            }
            throw new NoSuchElementException();
        }
        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public T front() {
        if (!s2.isEmpty()) return s2.peek();
        return front;
    }

    private boolean populateS2() {
        if (s1.isEmpty()) return false;
        while (!s1.isEmpty()) s2.push(s1.pop());
        return true;
    }
}
