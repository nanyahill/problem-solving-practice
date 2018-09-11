package com.problems.classic_problems.dynamic_programming;

import java.util.Arrays;

/**
 * This question is similar to the edit distance, except that there are no substitution operations.
 * A common subsequence is identified by all identical character matches in an edit trace.
 * To maximize the number of matches, we must prevent substitution of non-identical characters.
 */
public class LongestCommonSubSequence {
    /******************* Recursion Approach (Non-DP) **************************
     **************************************************************************/
    public static int longestCommonSubSequence_Recursion(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        return longestCommonSubSequence_Recursion(s1, s2, s1.length(), s2.length());
    }

    private static int longestCommonSubSequence_Recursion(String s1, String s2, int i, int j) {
        int count;
        if (i == 0 || j == 0) return 0;
        if (match(s1.charAt(i - 1), s2.charAt(j - 1)) == 1)
            count = 1 + longestCommonSubSequence_Recursion(s1, s2, i - 1, j - 1);
        else {
            int tmp1 = longestCommonSubSequence_Recursion(s1, s2, i - 1, j); // delete
            int tmp2 = longestCommonSubSequence_Recursion(s1, s2, i, j - 1); // insert
            count = Math.max(tmp1, tmp2);
        }
        return count;
    }

    /******************* Top Down DP Approach **************************
     *******************************************************************/
    public int longestCommonSubSequence_TopDown(String s1, String s2) {
        if (s1 == null || s2 == null) return -1;
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        initCache_TopDown(cache);
        return longestCommonSubSequence_TopDown(s1, s2, s1.length(), s2.length(), cache);
    }

    private int longestCommonSubSequence_TopDown(String s1, String s2, int i, int j, int[][] cache) {
        if (i == 0 || j == 0) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        if (match(s1.charAt(i - 1), s2.charAt(j - 1)) == 1) //(s1.charAt(i - 1) == s2.charAt(j - 1))
            cache[i][j] = 1 + longestCommonSubSequence_TopDown(s1, s2, i - 1, j - 1, cache);
        else {
            int tmp1 = longestCommonSubSequence_TopDown(s1, s2, i - 1, j, cache);
            int tmp2 = longestCommonSubSequence_TopDown(s1, s2, i, j - 1, cache);
            cache[i][j] = Math.max(tmp1, tmp2);
        }
        return cache[i][j];
    }

    /******************* Bottom Up DP Approach Time: O(), Space: **************************
     *******************************************************************/
    public static int longestCommonSubSequence_BottomUp(String s1, String s2) {
        if(s1 == null || s2 == null) return -1;
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) cache[i][j] = cache[i - 1][j - 1] + 1;
                else cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
            }
        }
        return cache[s1.length()][s2.length()];
    }

    private static void initCache_TopDown(int[][] cache) {
        for (int i = 0; i < cache.length; i++) Arrays.fill(cache[i], -1);
    }

    private static int match(char a, char b) {
        return a == b ? 1 : 0;
    }

    public static void main(String[] args) {
        //System.out.print(longestCommonSubSequence_Recursion("agxtab", "ggtywab"));
        String s = "    abcde   ";
        s = s.trim();
        System.out.print(s);
    }
}
