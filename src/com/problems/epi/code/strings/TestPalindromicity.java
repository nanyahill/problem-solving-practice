package com.problems.epi.code.strings;

public class TestPalindromicity {

    /**
     * Key Insights:
     * 1) Testing for palindrome can be verified using two pointers from opposite directions.
     * When they cross; palindromicity has been verified.
     * 2) In this problem, you also need to skip non-alphanumeric characters.
     * This can be achieved by incrementing i or decrementing j passed this character.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPlaindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(!Character.isLetterOrDigit(s.charAt(i)) && i < j) i++;
            while(!Character.isLetterOrDigit(s.charAt(j)) && i < j) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

}
