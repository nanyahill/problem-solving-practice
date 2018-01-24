package com.problems.epi.code.stacks_queues.implementation;

import com.util.ListNode;
import java.util.NoSuchElementException;

/**
 * This implementation is good because:
 * 1. Overcomes the fixed capacity issue with the array-based approach.
 * This implementation is bad because:
 * 1. It wastes space as each node has to store reference to the next node
 * Time Complexity: All operations are O(1)
 */
public class MyStack_UsingLinkedList<T> {

    private ListNode<T> top = null;

    public void push(ListNode node) {
        if (top == null) {
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) throw new NoSuchElementException();
        T tmp = top.data;
        top = top.next;
        return tmp;
    }

    public T peek() {
        if (top == null) throw new NoSuchElementException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
