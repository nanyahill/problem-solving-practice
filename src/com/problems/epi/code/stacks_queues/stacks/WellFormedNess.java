package com.problems.epi.code.stacks_queues.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem Type: Data Structure Problem & String Processing
 */
public class WellFormedNess {

    /**
     * Key Insight: For every left symbol, you need to find a matching right symbol.
     * The order of the right symbol matters because the last left symbol seen must match the first right symbol found.
     * This mimicks a stack of LIFO. hence, use a Stack, to store all left symbols found.
     * If a right symbol is encountered, check the top of the stack and see if the left symbol there matches the right symbol found.
     * If not there, the string is not well formed.
     * Note that it might seem obvious to use six count variables to keep a count of left and right versions of the three symbols
     * HOWEVER, this would not work for the input case were "([)]" since the ORDERING matters in this problem.
     * Time Complexity: O(n)
     * Space Complexity: O(n) (cannot do better; maybe better if there was only one type of symbol (use counter variables))
     */
    public static boolean isWellFormed(String s) {
        if (s == null || s.length() == 0) return true;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if (c == ')' && top != '(' || c == ']' && top != '[' || c == '}' && top != '{') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
