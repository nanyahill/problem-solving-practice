package com.problems.ctci.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Question3_3 {

    private class SetOfStacks {
        List<Stack> stacks = new ArrayList<>();
        int capacity;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            Stack last = getLastStack();
            if(last != null && !last.isFull()) {
                last.push(val);
            }
            else {
                last = new Stack(capacity);
                stacks.add(last);
                last.push(val);
            }
        }

        public int pop() {
            Stack last = getLastStack();
            if(last == null || last.isEmpty()) throw new NoSuchElementException();
            int v = last.pop();
            if(last.isEmpty()) stacks.remove(stacks.size() - 1);
            return v;
        }

        public int popAt_NoRollingOver(int idx) {
            if(idx >= stacks.size()) throw new IllegalArgumentException();
            Stack stack = stacks.get(idx);
            if(stack.isEmpty()) throw new NoSuchElementException();
            int v = stack.pop();
            if(stack.isEmpty()) stacks.remove(idx); // optional
            return v;
        }

        public int popAt_WithRollingOver(int idx) {
            if(idx >= stacks.size()) throw new IllegalArgumentException();
            return leftShift(idx, true);
        }

        private int leftShift(int idx, boolean removeTop) {
            Stack stack = stacks.get(idx);
            int removedItem = 0;
            if(removeTop) removedItem = stack.pop();
            else removedItem = stack.removeBottom();
            if(stack.isEmpty()) stacks.remove(idx);
            else if(idx + 1 < stack.size) {
                int v = leftShift(idx + 1, false);
                stack.push(v);
            }
            return removedItem;
        }

        private Stack getLastStack() {
            if(stacks.isEmpty()) return null;
            return stacks.get(stacks.size() - 1);
        }
    }

    private static class Stack {
        int capacity;
        Node top, bottom;
        int size;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean push(int val) {
            if(isFull()) return false;
            Node n = new Node(val);
            join(n, top);
            top = n;
            if(isEmpty()) bottom = n;
            size++;
            return true;
        }

        private void join(Node above, Node below) {
            if(above != null) above.below = below;
            if(below != null) below.above = above;
        }

        public int pop() {
            if(isEmpty()) throw new NoSuchElementException();
            Node v = top;
            top = v.below;
            size--;
            return v.value;
        }

        private int removeBottom() {
            Node n = bottom;
            bottom = n.above;
            if(bottom != null) bottom.below = null;
            return n.value;
        }

        public boolean isEmpty() { return size == 0; }

        public boolean isFull() { return size == capacity; }
    }

    private static class Node {
        Node above;
        Node below;
        int value;

        public Node(int val) { this.value = val; }
    }
}
