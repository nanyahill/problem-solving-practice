package com.problems.dynamic_programming;

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
    public static int longestCommonSubSequence_TopDownDP(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int[][] cache = new int[s1.length()][s2.length()];
        Arrays.fill(cache, -1);
        return longestCommonSubSequence_TopDownDP(s1, s2, s1.length(), s2.length(), cache);
    }

    private static int longestCommonSubSequence_TopDownDP(String s1, String s2, int i, int j, int[][] cache) {
        if(cache[i][j] != -1) return cache[i][j];
        if (match(s1.charAt(i - 1), s2.charAt(j - 1)) == 1) // match exists
            cache[i][j] = 1 + longestCommonSubSequence_TopDownDP(s1, s2, i - 1, j - 1, cache);
        else { // match does not exist, do insert and delete
            int tmp1 = longestCommonSubSequence_TopDownDP(s1, s2, i - 1, j, cache); // delete
            int tmp2 = longestCommonSubSequence_TopDownDP(s1, s2, i, j - 1, cache); // insert
            cache[i][j] = Math.max(tmp1, tmp2);
        }
        return cache[i][j];
    }

    /******************* Bottom Up DP Approach Time: O(), Space: **************************
     *******************************************************************/
    public static int longestCommonSubSequence_BottomUpDP(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int[][] cache = new int[s1.length()][s2.length()];
        Arrays.fill(cache, -1);
        return cache[s1.length()][s2.length()];
    }

    private static void initTable_BottomUp(int[][] table) {
        for (int i = 0; i < table.length; i++) table[i][0] = i;
        for (int j = 0; j < table[0].length; j++) table[0][j] = j;
    }

    private static int match(char a, char b) {
        return a == b ? 1 : 0;
    }

    public static void main(String[] args) {
        //System.out.print(longestCommonSubSequence_Recursion("TG", "TGTTCAGGTATCTGCTCGACAGGTCCCGCGCGCCAACCG"));
        System.out.print(longestCommonSubSequence_Recursion("aaa", "aaa"));
        //TG	TGTTCAGGTATCTGCTCGACAGGTCCCGCGCGCCAACCG // 37
    }
}
