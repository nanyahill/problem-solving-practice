package com.problems.epi.code.arrays.implementation;

import java.util.Iterator;

public class MyArrayList<E> {

    final int DEFAULT_CAPACITY = 10;
    int size;
    E[] data;

    public MyArrayList() {
        this.size = 0;
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.size = 0;
        if(capacity == 0) {
            data = (E[]) new Object[DEFAULT_CAPACITY];
        }
        else if(capacity > 0) {
            data = (E[]) new Object[capacity];
        }
        else {
            throw new IllegalArgumentException("Illegal Argument: " + capacity);
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int idx) {
        if(idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[idx];
    }

    public E set(int idx, E val) {
        if(idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = data[idx];
        data[idx] = val;
        return old;
    }

    public void add(E val) {
        add(size(), val);
    }

    private void add(int idx, E val) {
        if(size() == data.length) {
            E[] old = data;
            data = (E[]) new Object[size() * 2];
            for(int i = 0; i < size(); i++) {
                data[i] = old[i];
            }
        }
        for(int i = size(); i > idx; i--) {
            data[i] = data[i - 1];
        }
        data[idx] = val;
        size++;
    }

    public E remove(int idx) {
        E old = data[idx];
        for(int i = idx; i < size() - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return old;
    }

    public int find(E val) {
        for(int i = 0; i < size(); i++) {
            if(data[i].equals(val)) {
                return i;
            }
        }
        return -1; //search failed
    }

//    public int findFromSorted(E val) {
//        // Using binary search
//        int i = 0, j = size() - 1;
//        while(i < j) {
//            int mid = (i + j) / 2;
//            if(data[mid] == val) return i;
//            else if(data[mid] < val) i = mid + 1;
//            else j = mid - 1;
//        }
//        return -1; //search failed
//    }

    public MyArrayListIterator<E> iterator() {
        return new MyArrayListIterator<E>();
    }

    private class MyArrayListIterator<E> implements Iterator<E> {
        int current = 0; // position of the next element to be returned

        public boolean hasNext() {
            return current < size();
        }

        public E next() {
            if(current >= size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return (E) data[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
