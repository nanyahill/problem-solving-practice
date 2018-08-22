package com.problems.epi.code.classic_dynamic_programming;

public class LevenshteinDistance {
    /******************* Recursion Approach (Non-DP) **************************
     **************************************************************************/
    public static int editDistance_Recursion(String s1, String s2) {
        if(s1 == null || s2 == null) return 0;
        return editDistance_Recursion(s1, s2, s1.length(), s2.length());
    }

    private static int editDistance_Recursion(String s1, String s2, int i, int j) {
        int[] cost = new int[3];
        if(i == 0)return j;
        else if(j == 0) return i;
        cost[0] = match(s1.charAt(i-1), s2.charAt(j-1)) + editDistance_Recursion(s1, s2, i - 1, j - 1);
        cost[1]  = 1 + editDistance_Recursion(s1, s2, i - 1, j); // delete
        cost[2]  = 1 + editDistance_Recursion(s1, s2, i, j - 1); // insert
        return Math.min(cost[0], Math.min(cost[1], cost[2]));
    }

    /******************* Top Down DP Approach **************************
     *******************************************************************/
    public static int editDistance_TopDownDP(String s1, String s2) {
        if(s1 == null || s2 == null) return 0;
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        initTable_TopDown(table); //init table to -1
        return editDistance_TopDownDP(s1, s2, s1.length(), s2.length(), table);
    }

    private static int editDistance_TopDownDP(String s1, String s2, int i, int j, int[][] table) {
        // return i or j as base case because if the end of either string is reached , you would need to do
        // either an insert or delete operation i or j times.
        if(i == 0) return j;
        if(j == 0) return i;
        if(table[i][j] == -1) {
            //if(match(s1.charAt(i - 1), s2.charAt(j - 1)) == 0) return editDistance_TopDownDP(s1, s2, i - 1, j - 1, table);
            //else {
            int subLast = 1 + editDistance_TopDownDP(s1, s2, i - 1, j - 1, table);
            int delLast = 1 + editDistance_TopDownDP(s1, s2, i - 1, j, table);
            int addLast = 1 + editDistance_TopDownDP(s1, s2, i, j - 1, table);
            table[i][j] = Math.min(subLast, Math.min(addLast, delLast));
            //}
        }
        return table[i][j];
    }

    /******************* Bottom Up DP Approach Time: O(), Space: **************************
     *******************************************************************/
    public static int editDistance_BottomUpDP(String s1, String s2) {
        if(s1 == null || s2 == null) return 0;
        int m = s1.length();
        int n = s2.length();
        int[][] table = new int[m + 1][n + 1];
        initTable_BottomUp(table);
        int[] cost = new int[3];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j ++) {
                cost[0] = match(s1.charAt(i - 1), s2.charAt(j - 1)) + table[i - 1][j - 1]; // subs
                cost[1] = 1 + table[i - 1][j]; // delete
                cost[2] = 1 + table[i][j - 1]; // insert
                table[i][j] = Math.min(cost[0], Math.min(cost[1], cost[2]));
            }
        }
        return table[m][n];
    }

    private static void initTable_BottomUp(int[][] table) {
        for(int i = 0; i < table.length; i++) table[i][0] = i;
        for(int j = 0; j < table[0].length; j++) table[0][j] = j;
    }

    private static void initTable_TopDown(int[][] table) {
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[0].length; j++) {
                table[i][j] = -1;
            }
        }
    }

    private static int match(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static void main(String[] args) {
        //System.out.print(longestCommonSubSequence_Recursion("TG", "TGTTCAGGTATCTGCTCGACAGGTCCCGCGCGCCAACCG"));
        System.out.print(editDistance_Recursion("AGGTAB", "GXTXAYB"));
        //TG	TGTTCAGGTATCTGCTCGACAGGTCCCGCGCGCCAACCG // 37
    }
}