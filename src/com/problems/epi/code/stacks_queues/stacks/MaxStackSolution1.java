package com.problems.epi.code.stacks_queues.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Key Insight: Consider two questions:
 * Is there a way to keep track of the max at every push()?
 * Is there a way to update the max if it it removed during a pop()?
 */

public class MaxStackSolution1 {

    static class NodeWithMax {
        public int value;
        public int max;

        public NodeWithMax(int value, int max) {
            this.value = value;
            this.max = max;
        }
    }

    /**
     * TreeTraversal_Recursive 1: Create an inner class that would store the value to be added and the current max seen so far.
     * However,this solution would result in a lot of wasted space if the number of elements to be added is large
     */
    public static Deque<NodeWithMax> elements = new ArrayDeque<>();

    public static void push(int value) {
        if (elements.isEmpty()) {
            elements.addFirst(new NodeWithMax(value, value));
            return;
        }
        elements.addFirst(new NodeWithMax(value, Math.max(value, max())));
    }

    public static int max() {
        if (elements.isEmpty()) throw new NoSuchElementException();
        return elements.peek().max;
    }

    public static int pop() {
        if (elements.isEmpty()) throw new NoSuchElementException();
        return elements.removeFirst().value;
    }
}
