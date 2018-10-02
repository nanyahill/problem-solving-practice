package com.problems.ctci.chapter1;

public class Question1_2 {

    public static boolean isPermutation(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        int[] charCount = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            charCount[c]++;
        }
        for(int j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);
            charCount[c]--;
            if(charCount[c] < 0) return false;
        }
        return true;
    }
}
