package com.util;


/**
 * A class used to solve Linked List related problems
 */
public class ListNode<T> {

    public T data;
    public ListNode<T> next = null;

    public ListNode (T data) {
        this.data = data;
    }

    public ListNode (T data, ListNode<T> node) {
        this.data = data;
        next = node;
    }
}
