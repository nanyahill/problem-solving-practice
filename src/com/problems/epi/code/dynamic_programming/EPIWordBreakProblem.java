package com.problems.epi.code.dynamic_programming;

import java.util.*;

public class EPIWordBreakProblem {
    public String wordBreakReturnAnySolution(String s, List<String> wordDict) {
        Map<Integer, String> memo = new HashMap<>();
        return wordBreakReturnAnySolutionBacktracking(s, new HashSet<>(wordDict), 0);
        // return wordBreakAnyOneSolutionTopDown_Memoization(s, new HashSet<>(wordDict), memo);
    }

    public String wordBreakReturnAnySolutionBacktracking(String s, Set<String> wordDict, int start) {
        if (start == s.length()) return s.substring(start);
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordDict.contains(prefix)) {
                String segmentedSuffix = wordBreakReturnAnySolutionBacktracking(s, wordDict, end);
                if (segmentedSuffix != null) {
                    return prefix + " " + segmentedSuffix;
                }
            }
        }
        return null;
    }

    public String wordBreakReturnAnySolutionTopDown_Memoization(String s, Set<String> wordDict, int start, Map<Integer, String> memo) {
        if (start == s.length()) return s.substring(start);
        if (memo.containsKey(start)) return memo.get(start);
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordDict.contains(prefix)) {
                String segmentedSuffix = wordBreakReturnAnySolutionTopDown_Memoization(s, wordDict, end, memo);
                if (segmentedSuffix != null) {
                    memo.put(start, prefix + " " + segmentedSuffix);
                    return memo.get(start);
                }
            }
        }
        memo.put(start, null);
        return null;
    }

    public static List<String>
    decomposeIntoDictionaryWords(String s, Set<String> dict) {
        if (dict == null || dict.size() == 0) return Collections.emptyList();
        Map<String, String> memoized = new HashMap<>();
        String res = wordBreak_TopDownDp_ListResults(s, dict, memoized);
        return res != null ? Arrays.asList(res.split(" ")) : Collections.emptyList();
    }

    /**
     * Alternative solution to the one above: Does not use the any start index
     */
    private static String wordBreak_TopDownDp_ListResults(String input, Set<String> dict, Map<String, String> memoized) {
        if (dict.contains(input)) return input;
        if (memoized.containsKey(input)) {
            return memoized.get(input);
        }
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                String segSuffix = wordBreak_TopDownDp_ListResults(suffix, dict, memoized);
                if (segSuffix != null) {
                    memoized.put(input, prefix + " " + segSuffix);
                    return prefix + " " + segSuffix;
                }
            }
        }
        memoized.put(input, null);
        return null;
    }
}
