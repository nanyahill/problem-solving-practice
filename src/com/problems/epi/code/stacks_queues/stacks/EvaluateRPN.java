package com.problems.epi.code.stacks_queues.stacks;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Problem Type: Data Structure Problem & String Processing
 * Key Insight: Two integers are processes for each arithmetic symbol encountered.
 * The result is pushed onto the stack. Continue until all the input has been processed.
 */
public class EvaluateRPN {

    /**
     * This solution shows how the algo with look like if input is a string
     * Time Complexity: O(n)
     * Space Complexity: O(n) since we use a stack
     */
    public static int evaluateRPN_WithInputString(String str) {
        if (str == null || str.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = str.split(",");
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if ("+*/-".contains(s)) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(val1 + val2);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val1 * val2);
                        break;
                    case "/":
                        if (val1 != 0) stack.push(val2 / val1);
                        else stack.push(0);
                        break;
                    default:
                        throw new IllegalStateException();
                }
            } else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    /**
     * This solution shows how the algo with look like if input is a string aray
     * Time Complexity: O(n)
     * Space Complexity: O(n) since we use a stack
     */
    public static int evaluateRPN_WithInputArray(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int a, b;
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a + b);
            } else if (str.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (str.equals("*")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a * b);
            } else if (str.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }
}
