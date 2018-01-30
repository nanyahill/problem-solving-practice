package com.problems.epi.code.stacks_queues.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Key Insight: Consider two questions:
 * Is there a way to keep track of the max at every push()?
 * Is there a way to update the max if it it removed during a pop()?
 */

public class MaxStackSolution2 {
    /**
     * TreeTraversal_Recursive 2: Key Insight: Any current number that is being pushed can NEVER be the maximum;
     * iff it is less than the current max seen so far.
     * Hence, ONLY values that are greater than or equal to current max would be updated in the maxElements list/stack.
     * Implementation Notes: All max seen is stored i n a stack such that the lastest max is always ta the top.
     */
    static Deque<Integer> elements = new ArrayDeque<>();
    static Deque<Integer> maxElements = new ArrayDeque<>();

    public static void push(int value) {
        if (elements.isEmpty()) {
            elements.push(value);
            maxElements.push(value);
            return;
        } else if (value >= max()) maxElements.push(value);
        elements.push(value);
    }

    public static int pop() {
        if (elements.isEmpty()) throw new NoSuchElementException();
        int toRemove = elements.removeFirst();
        if (toRemove == max()) maxElements.removeFirst();
        return toRemove;
    }

    public static int max() {
        if (maxElements.isEmpty()) throw new NoSuchElementException();
        return maxElements.peek();
    }
}
