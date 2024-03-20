package com.problems.epi.code.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem Type: Strings & Combinatorial
 */
public class PhoneNumberMnemonics {

    /**
     * 1) Generate all enumerations usually results in a Brute Force solution where 7 nested loops are needed.
     * Each loop iterates over the whole length of character it represents.
     * 2) A better solution is to use recursion
     * that is similar to the brute force except that the compiler handles the looping.
     * Time Complexity: O(n4^n)
     * Space Complexity: O(1)
     */
    private static final String[] KEYS = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> phoneMnemonic(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.length() == 0) return null;
        char[] prefix = new char[phoneNumber.length()];
        List<String> result = new ArrayList<>();
        phoneMnemonicHelper(phoneNumber, prefix, 0, result);
        return result;
    }

    // This old method uses string concatenation which is not efficient because a new string is created each time
//    private static void phoneMnemonicHelper(String phoneNumber, int pos, String prefix, List<String> res) {
//        if(pos == phoneNumber.length()) {
//            res.add(new String(prefix));
//        }
//        else {
//            int digit = phoneNumber.charAt(pos) - '0';
//            for(int i = 0; i < map[digit].length(); i++) {
//                char c = map[digit].charAt(i);
//                phoneMnemonicHelper(phoneNumber, pos + 1, prefix + c, res);
//            }
//        }
//    }

    private static void phoneMnemonicHelper(String digits, char[] prefix, int idx, List<String> res) {
        if (idx == digits.length()) {
            res.add(new String(prefix));
            return;
        } else {
            String chars = KEYS[digits.charAt(idx) - '0'];
            for (int i = 0; i < chars.length(); i++) {
                prefix[idx] = chars.charAt(i);
                phoneMnemonicHelper(digits, prefix, idx + 1, res);
            }
        }
    }

    private static final String[] MAPPINGS = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    public static List<String> phoneMnemonicIterative(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if(digits == null) return queue;
        queue.add("");
        for(int i = 0; i < digits.length(); i++) {
            String chars = MAPPINGS[digits.charAt(i) - '0'];
            while(!queue.isEmpty() && queue.peek().length() == i) {
                String s = queue.remove();
                for (char c : chars.toCharArray()) {
                    queue.add(s + Character.toUpperCase(c));
                }

            }
        }
        return queue;
    }

    public static void main(String[] args) {
        String nums = "798";
        phoneMnemonicIterative(nums);

    }

}
