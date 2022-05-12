package com.problems.epi.code.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/** This problem is similar to Word Ladder Problem in LeetCode #127 */

/**
 * Understanding the problem: Find the shortest sequence of words that transform string s to a string t
 * Example: [hot, hit, dot, hat], "hit", "dot". Result: hit -> hot -> dot
 * Key Insights: Shortest path points to BFS
 * The words in the dictionary are the vertices and the edge (u,v) indicates that the strings
 * corresponding to u and v differ in exactly one character.
 *
 * Gotchas:
 * Be wary of doing string concatenation here as this creates a new string with each concatenation
 * and a copy over characters each time.
 * Do we need an extra object- StringWithDistance? No, see approach transformString_TimeAndSpaceEfficient
 */
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

    // Inspired by LeetCode Discuss-https://leetcode.com/problems/word-ladder/discuss/1764371/A-very-highly-detailed-EXPLANATION
    public static int transformString_TimeAndSpaceEfficient(Set<String> dict, String s, String t) {
        Set<String> visited = new HashSet<>(dict);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        visited.remove(s);
        int changes = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // This is important so that we process the sequence level by level
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(t)) return changes;
                for (int i = 0; i < curr.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] currWordArray = curr.toCharArray();
                        currWordArray[i] = c;
                        String str = new String(currWordArray);
                        if (visited.contains(str)) {
                            queue.add(str);
                            visited.remove(str);
                        }
                    }
                }
            }
            // We do this here because after processing a level (i.e. end of outer for loop)
            // at most one change (or word) is added to the sequence
            ++changes;
        }
        return -1;
    }
}
