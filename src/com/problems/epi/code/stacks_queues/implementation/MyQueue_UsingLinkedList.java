package com.problems.epi.code.stacks_queues.implementation;

import com.util.ListNode;
import java.util.NoSuchElementException;

/**
 * This implementation is good because:
 * 1. No need to specify a maximum capacity
 * This is implementation is bad because:
 * 1. Each ListNode stores a next reference more space per element is used than with array-based implementation
 * 2. Push opeartions have more number of primitive operations per call.
 * E.g. initialize a new node, re-link existing node to new node, and increment the size counter
 * Time complexity: All operations are O(1)
 */
public class MyQueue_UsingLinkedList<T> {
    ListNode<T> head, tail;
    int size = 0;

    public void enqueue(T val) {
        ListNode<T> node = new ListNode<>(val);
        if (head == null && tail == null) {
            head = tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode n = head;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return (T) n.data;
    }

    public T front() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
