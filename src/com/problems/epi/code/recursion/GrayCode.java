package com.problems.epi.code.recursion;

import java.util.*;

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        Set<Integer> visited = new HashSet<>(Arrays.asList(0));
        backtracking(n, result, visited);
        return result;
    }

    /**
     * Time: O(n.2^n)
     * Space: O(n)
     */
    private static boolean backtracking(int n, List<Integer> result, Set<Integer> visited) {
        if (result.size() == (1 << n)) {
            return true;
        }
        for (int i = 0; i < n; i++) { // !! Important that it is from 0 to n -1 instead of 0 to (1 << n)
            int previous = result.get(result.size() - 1);
            int next = previous ^ (1 << i);
            if (!visited.contains(next)) {
                visited.add(next);
                result.add(next);
                if (backtracking(n, result, visited)) return true;
                visited.remove(next);
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    /**
     * Time: O(n.2^n)
     * Space: O(1)
     */
    private static List<Integer> recursion(int n) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0));
        for (int i = 1; i <= n; i++) {
            int currentSeqLength = result.size();
            int mask = 1 << (i - 1);
            for (int j = currentSeqLength - 1; j >= 0; j--) {
                result.add(mask | result.get(j));
            }
        }
        return result;
    }
}
