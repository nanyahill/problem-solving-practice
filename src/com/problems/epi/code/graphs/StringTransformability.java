package com.problems.epi.code.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/** This problem is similar to Word Ladder Problem in LeetCode */
public class StringTransformability {

    private static class StringWithDistance {
        String str;
        int distance;

        StringWithDistance(String str, int distance) {
            this.str = str;
            this.distance = distance;
        }

    }

    // Uses BFS to find the least steps of transformation.
    // This is a shortest path problem and is naturally computed using BFS.
    public static int transformString(Set<String> dict, String s, String t) {
        Set<String> visited = new HashSet<>(dict);
        Queue<StringWithDistance> queue = new ArrayDeque<>();
        queue.add(new StringWithDistance(s,0));
        visited.remove(s);
        while(!queue.isEmpty()) {
            StringWithDistance curr = queue.poll();
            if(curr.str.equals(t)) return curr.distance;
            for(int i = 0; i < curr.str.length(); i++) {
                String start = i == 0 ? "" : curr.str.substring(0, i);
                String end = i + 1 < curr.str.length() ? curr.str.substring(i+1) : "";
                for(int j = 0; j < 26; j++) {
                    String str = start + (char) ('a' + j) + end;
                    if(visited.contains(str)) {
                        queue.add(new StringWithDistance(str, curr.distance + 1));
                        visited.remove(str);
                    }
                }
            }
        }
        return -1;
    }
}
