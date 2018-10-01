package com.problems.ctci.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time complexity ; O(n^2), Space: O(n)
 */
public class Question3_5 {

    public static Deque<Integer> sortStack(Deque<Integer> stack) {
        if(stack == null || stack.isEmpty()) return null;
        Deque<Integer> tmp = new ArrayDeque<>();
        while(!stack.isEmpty()) {
            int val= stack.pop();
            // CTCI uses (tmp.peek() > val) this is confusing
            // Because- the question says smallest elements should be in the resulting stack
            // what is the resulting stack? the tmp stack or the original stack
            // if tmp stack: then you need to test (tmp.peek() < val)
            // if original stack: then you need to test (tmp.peek() > val) and move elements from
            // tmp stack to original stack as a final step.
            // Note: Overall, there is an implicit assumption that the stack return would be popped
            // and inserted into another stack. Hence, the returned stack should have largest elements on top.
            while(!tmp.isEmpty() && (tmp.peek() > val)) stack.push(tmp.pop());
            tmp.push(val);
        }
        //return tmp; CTCI stops here!

        // I believe to justify the (tmp.peek() > val) above we should move tmp stack back to original stack
        while(!tmp.isEmpty()) stack.push(tmp.pop());
        return stack;
    }
}
