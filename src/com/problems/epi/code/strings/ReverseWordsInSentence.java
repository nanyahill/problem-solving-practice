package com.problems.epi.code.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Problem Type: String Problem
 * Variants of this problem as seen in Leetcode:
 * [solved with removeMultipleSpaces()]151: Reverse words in string: presence of trailing spaces & multiple space in btw words. Result should have single space btw words
 * [solved]186: Reverse Words in string II: presence of single space btw words, do it in place
 * [solved]334: Reverse String: Simply use the helper function below (reverse)
 * 541: Reverse String II: Reverse the first k characters
 * 557: Reverse words in string III: reverse individual words ONLY, while still preserving whitespace and initial word order.
 */
public class ReverseWordsInSentence {

    /**
     * This solution assumes that multiple white spaces can exist between words
     * 1) You can do this easily with extra memory (Brute force) How can we do this without extra memory?
     * Reverse the whole sentence first.
     * 2) Then, reverse each word starting from the front. Since the whole sentence is reversed first;
     * white spaces are already in their correct position and do not need to be reversed when reversing each word.
     * 3) The start and end indicies when reversing words must begin and end with characters that are NOT white space.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static char[] reverseWordsInSentence(char[] chars) {
        if (chars == null || chars.length == 0) return null;

        // Reverse whole sentence first
        reverse(chars, 0, chars.length - 1);
        int i = 0, j = 0, n = chars.length;
        while (i < n) {
            // the first while below may not be necessary if the question specifies that ONLY a single space
            /// between words. In this case, you can remove the first while loop and uncomment lines 35-36
            while (i < j || (i < n) && chars[i] == ' ') i++;
            while (j < i || (j < n) && chars[j] != ' ') j++;
            reverse(chars, i, j - 1);
            // start = end + 1;
            //++end;
        }
        return chars;
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    // Used in leetcode problem #151
    private static String removeMultipleSpaces(char[] chars) {
        int writeIdx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' || (i > 0 && chars[i] == ' ' && chars[i - 1] != ' ')) {
                chars[writeIdx] = chars[i];
                writeIdx++;
            }
        }
        String result = new String(chars);
        return result.substring(0, writeIdx);
    }

    // Uses built in split + reverse
    // O(n) time and O(n) space for #151 leetcode
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
