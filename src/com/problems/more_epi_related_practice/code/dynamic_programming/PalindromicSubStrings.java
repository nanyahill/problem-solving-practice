package com.problems.more_epi_related_practice.code.dynamic_programming;

public class PalindromicSubStrings {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        boolean[][] table = new boolean[s.length()][s.length()];
        int result = s.length();
        for (int i = 0; i < s.length(); i++) {
            table[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            table[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            result += table[i][i + 1] ? 1 : 0;
        }

        for (int diff = 2; diff < s.length(); diff++) {
            for (int i = 0; i < s.length() - diff; i++) {
                int j = i + diff;
                table[i][j] = s.charAt(i) == s.charAt(j) && table[i + 1][j - 1];
                result += table[i][j] ? 1 : 0;
            }
        }
        return result;
    }
}
