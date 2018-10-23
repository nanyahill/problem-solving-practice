package com.problems.ctci.chapter1;

public class Question1_9 {

    public static boolean isRotation(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        else if(s1.length() != s2.length()) return false;
        String s1s1 = s1 + s1; // key insight!
        if(isSubstring(s1s1, s2)) return true;
        return false;
    }

    private static boolean isSubstring(String big, String small) {
        return big.indexOf(small) >= 0;
    }
}
