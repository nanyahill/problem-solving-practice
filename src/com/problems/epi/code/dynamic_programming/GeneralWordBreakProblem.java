package com.problems.epi.code.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneralWordBreakProblem {

    /**
     * Check if any one solution exists.
     * <a href="https://leetcode.com/problems/word-break/">...</a>
     */
    public boolean wordBreakDoesSolutionExists(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakDoesSolutionExistsBacktracking(s, new HashSet<>(wordDict), 0);
        // return wordBreakDoesSolutionExistsTopDown_Memoization(s, new HashSet<>(wordDict), memo, 0);
    }

    public boolean wordBreakDoesSolutionExistsBacktracking(String s, Set<String> wordDict, int start) {
        if (start == s.length()) return true;
        for (int end = start + 1; end <= s.length(); end++) {
            //String prefix = s.substring(start, end);
            if (wordDict.contains(s.substring(start, end)) && wordBreakDoesSolutionExistsBacktracking(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakDoesSolutionExistsTopDown_Memoization(String s, Set<String> wordDict, Boolean[] memo, int start) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakDoesSolutionExistsTopDown_Memoization(s, wordDict, memo, end)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public boolean wordBreakDoesSolutionExistsBottomUp_Tabulation(String s, Set<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    /**
     * Return any one solution that exists.
     * EPI- 16.7
     */
    public String wordBreakReturnAnySolution(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakReturnAnySolutionBacktracking(s, new HashSet<>(wordDict), 0);
        // return wordBreakAnyOneSolutionTopDown_Memoization(s, new HashSet<>(wordDict), memo);
    }

    public String wordBreakReturnAnySolutionBacktracking(String s, Set<String> wordDict, int start) {
        if (start == s.length()) return s.substring(start);
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if(wordDict.contains(prefix)) {
                String segmentedSuffix = wordBreakReturnAnySolutionBacktracking(s, wordDict, end);
                if(segmentedSuffix != null) {
                    return prefix + " " + segmentedSuffix;
                }
            }
        }
        return null;
    }

    public String wordBreakReturnAnySolutionTopDown_Memoization(String s, Set<String> wordDict, int start, String[] memo) {
        if (start == s.length()) return s.substring(start);
        if(memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if(wordDict.contains(prefix)) {
                String segmentedSuffix = wordBreakReturnAnySolutionTopDown_Memoization(s, wordDict, end, memo);
                if(segmentedSuffix != null) {
                    return memo[start] = prefix + " " + segmentedSuffix;
                }
            }
        }
        return memo[start];
    }

    // IT IS NOT WORKING IN EPI JUDGE. STILL NEED TO FIGURE IT OUT
    public String wordBreakReturnAnySolutionBottomUp_Tabulation(String s, Set<String> wordDict, int start, String[] memo) {
        // make sure memo[0] = "" in the caller of this method
        for (int end = 1; end <= s.length(); end++) {
            for(int j = 0; j < end; j++){
                String word = s.substring(j + 1, end);
                if(memo[j] != null && wordDict.contains(word)) {
                    memo[end] = memo[j] + " " + word;
                    break;
                    //return memo2[j] + " " + word;
                }
            }
        }
        return memo[s.length()];
    }

    /**
     * Prints all the words possible instead of just one combination.
     * Reference
     * https://leetcode.com/problems/word-break-ii/
     */
}
