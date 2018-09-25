package com.problems.ctci.chapter3;

import java.util.NoSuchElementException;

public class ThreeStacksInOneArray {
    int[] data;
    int[] sizes;
    int stackCapacity;

    public ThreeStacksInOneArray(int numOfStacks, int stackCapacity) {
        this.stackCapacity = stackCapacity;
        data = new int[numOfStacks * stackCapacity];
        sizes = new int[numOfStacks];
    }

    public void push(int stackIdx, int val) {
        if (isFull(stackIdx)) throw new IllegalStateException();
        sizes[stackIdx]++;
        data[getIndexOfTop(stackIdx)] = val;
    }

    public int pop(int stackIdx) {
        if (isEmpty(stackIdx)) throw new NoSuchElementException();
        int index = getIndexOfTop(stackIdx);
        int val = data[index];
        data[index] = 0;
        sizes[stackIdx]--;
        return val;
    }

    public int peek(int stackIdx) {
        if (isEmpty(stackIdx)) throw new NoSuchElementException();
        return data[getIndexOfTop(stackIdx)];
    }

    private int getIndexOfTop(int stackIdx) {
        int sizeOfStack = sizes[stackIdx];
        int startIndexOfStack = stackIdx * stackCapacity;
        return sizeOfStack + startIndexOfStack - 1;
    }

    private boolean isFull(int stackIdx) {
        return sizes[stackIdx] == stackCapacity;
    }

    private boolean isEmpty(int stackIdx) {
        return sizes[stackIdx] == 0;
    }
}
