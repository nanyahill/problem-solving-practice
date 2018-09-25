package com.problems.ctci.chapter1;

public class Question1_1 {

    public static boolean containsUniqueChars_ExtraSpace(String str) {
        if(str == null || str.length() > 128) return false;
        boolean[] charChecker = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(charChecker[c]) return false;
            charChecker[c] = true;
        }
        return true;
    }

    // Assume characters are lower case
    public static boolean containsUniqueChars_BitManipulation(String str) {
        if(str == null || str.length() == 0) return false;
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) == 1) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
