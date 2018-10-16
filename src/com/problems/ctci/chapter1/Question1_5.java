package com.problems.ctci.chapter1;

public class Question1_5 {

    public static boolean oneAway(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return s1 != null ? s1.length() <= 1 : s2 != null ? s2.length() <= 1 : true;
        }
        else if(Math.abs(s1.length() - s2.length()) > 1) return false;
        if(s1.length() > s2.length()) {
            String tmp = s2;
            s2 = s1;
            s1 = tmp;
        }
        int i = 0, j = 0;
        boolean foundDifference = false;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if(foundDifference) return false;
                foundDifference = true;
                if(s1.length() == s2.length()) i++;
            }
            else i++;
            j++;
        }
        return true;
    }

}
