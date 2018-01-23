package com.data_structures_impl;

import com.util.ListNode;
import java.util.NoSuchElementException;

/**
 * A class that implements the LinkedList data structure
 */
public class MyLinkedList<T> {

    public ListNode head = null;
    public ListNode tail = null;

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void pushFront(ListNode node) {
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head = node;
        }
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public ListNode popFront() {
        if(head == null) throw new NoSuchElementException();
        ListNode toDelete = head;
        head = head.next;
        return head;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public ListNode topFront() {
        return head;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void pushBackWithTail(ListNode node) {
        if(tail == null) {
            tail = node;
            head = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void pushBackWithoutTail(ListNode node) {
        if(head == null) head = node;
        else {
            ListNode curr = head;
            while(curr.next != null) curr = curr.next;
            curr.next = node;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode popBackWithTail() {
        if(tail == null) throw new NoSuchElementException();
        else if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            ListNode curr = head;
            while(curr.next != tail) curr = curr.next;
            curr.next = null;
            tail = curr;
        }
        return tail;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode popBackWithoutTail() {
        if(head == null) throw new NoSuchElementException();
        else {
            ListNode curr = head;
            while(curr.next != null && curr.next.next != null) curr = curr.next;
            ListNode toDelete = curr.next;
            curr.next = null;
        }
        return head;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public ListNode topBackWithTailPointer() {
        return tail;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode topBackWithoutTailPointer() {
        if(head == null) throw new NoSuchElementException();
        ListNode curr = head;
        while(curr.next != null) curr = curr.next;
        return curr;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void addAfter(ListNode nodeBefore, ListNode nodeToAdd) {
        if(head == null || nodeBefore == null) throw new NoSuchElementException();
        nodeToAdd.next = nodeBefore.next;
        nodeBefore.next = nodeToAdd;
        if(tail == nodeBefore) tail = nodeToAdd;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void addBefore (ListNode nodeAfter, ListNode nodeToAdd) {
        if(head == null) throw new NoSuchElementException();
        ListNode curr = head;
        while(curr.next != nodeAfter) curr = curr.next;
        nodeToAdd.next = nodeAfter;
        curr.next = nodeToAdd;
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode delete(ListNode nodeToDelete) {
        if(head == null || nodeToDelete == null) throw new NoSuchElementException();
        else {
            ListNode curr = head;
            while(curr.next != nodeToDelete) curr = curr.next;
            curr.next = nodeToDelete.next;
        }
        return head;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode find(ListNode nodeToFind) {
        if(head == null) throw new NoSuchElementException();
        else {
            ListNode curr = head;
            while(curr != nodeToFind) curr = curr.next;
            return curr;
        }
    }

}
