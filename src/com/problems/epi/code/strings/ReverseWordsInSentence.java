package com.problems.epi.code.strings;

import java.util.regex.Pattern;

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

    public static void reverseWords(char[] input) {

        int n = input.length;
        // First, reverses the whole string.
        reverse2(input, 0, n - 1);

        // Second, Reverses each word in the string.
        int start = 0, finish = 0;
        while (start < n) {
            while (start < finish || start < n && input[start] == ' ') {
                ++start; // Skip spaces chars.
            }
            while (finish < start || finish < n && input[finish] != ' ') {
                ++finish; // Skip non-spaces chars.
            }
            reverse2(input, start, finish - 1);
        }
        for(Character num : input)System.out.print(num);
    }

    private static void reverse2(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start++] = array[end];
            array[end--] = tmp;
        }
    }

    static String reverseWordsgg(String str)
    {

        // Specifying the pattern to be searched
        Pattern pattern = Pattern.compile("\\s");

        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = pattern.split(str);
        String result = "";

        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
    }

    public static void main(String[] args) {
        char[] input2 = {' ',' ',' ',' ','a','b',' ', 'b','c',' ',' '};
        String input3 = "    ab   bc  ";
       // reverseWords(input2);
       // System.out.print(input2.toString());
        System.out.print(input3.trim());
    }
}
