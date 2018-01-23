package com.data_structures_impl;

import com.util.ListNode;
import java.util.NoSuchElementException;

public class MyStack<T> {

    private ListNode<T> top = null;

    public void push(ListNode node) {
        if(top == null) {
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    public T pop() {
        if(top == null) throw new NoSuchElementException();
        T tmp = top.data;
        top = top.next;
        return tmp;
    }

    public T peek() {
        if(top == null) throw new NoSuchElementException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}