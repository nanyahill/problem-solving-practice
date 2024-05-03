package com.problems.epi.code.stacks_queues.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class DirectoryPathNormalization {

    public static String shortestEquivalentPathEPI(String path) {
        if (path == null || path.isEmpty()) return "";
        Deque<String> stack = new ArrayDeque<>();
        if (path.startsWith("/")) {
            stack.add("/");
        }
        for (String token : path.split("/")) {
            //if (token.isEmpty() || token.equals(".")) continue;
            if (token.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) {
                    stack.push(token); //push
                } else stack.pop(); //pop
            } else if (!token.isEmpty() || !token.equals(".")){
                stack.offerFirst(token);
            }
        }
        StringBuilder builder = new StringBuilder();
        if (!stack.isEmpty()) {
            String prev = stack.pollLast();
            builder.append(prev);
            while (!stack.isEmpty()) {
                if (!prev.equals("/")) {
                    builder.append("/");
                }
                prev = stack.pollLast();
                builder.append(prev);
            }
        }
        return builder.toString();
    }

    public static String shortestEquivalentPathLeetCode(String path) {
        if (path == null || path.isEmpty()) return "";
        Deque<String> stack = new ArrayDeque<>();
        for (String token : path.split("/")) {
            if (token.isEmpty() || token.equals(".")) continue;
            else if (token.equals("..")) {
                if (!stack.isEmpty()) stack.pollFirst();
            } else {
                stack.offerFirst(token);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/");
            builder.append(stack.pollLast());
        }
        return builder.toString().isEmpty() ? "/" : builder.toString();
    }
}
