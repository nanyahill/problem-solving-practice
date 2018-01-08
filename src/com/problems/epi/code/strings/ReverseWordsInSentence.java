package com.problems.epi.code.strings;

/**
 * Problem Type: String Problem
 */
public class ReverseWordsInSentence {

    /**
     * 1) You can do this easily with extra memory (Brute force) How can we do this without extra memory?
     * Reverse the whole sentence first.
     * 2) Then, reverse each word starting from the front. Since the whole sentence is reversed first;
     * white spaces are already in their correct position and do not need to be reversed when reversing each word.
     * 3) The start and end indicies when reversing words must begin and end with characters that are NOT white space.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static char[] reverseWordsInSentence(char[] chars) {
        if(chars == null || chars.length == 0) return null;

        // Reverse whole sentence first
        reverse(chars, 0, chars.length - 1);
        int i = 0, j = 0, n = chars.length;
        while(i < n) {
            while(i < j || (i < n) && chars[i] == ' ') i++;
            while(j < i || (j < n) && chars[j] != ' ') j++;
            reverse(chars, i, j - 1);
        }
        return chars;
    }

    private static void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
