package com.problems.epi.code.strings;

import java.util.ArrayList;
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
    static String[] map = {"0", "1", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> phoneMnemonic(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.length() == 0) return null;
        List<String> result = new ArrayList<>();
        phoneMnemonicHelper(phoneNumber, 0, "", result);
        return result;
    }

    private static void phoneMnemonicHelper(String phoneNumber, int pos, String prefix, List<String> res) {
        if(pos == phoneNumber.length()) {
            res.add(new String(prefix));
        }
        else {
            int digit = phoneNumber.charAt(pos) - '0';
            for(int i = 0; i < map[digit].length(); i++) {
                char c = map[digit].charAt(i);
                phoneMnemonicHelper(phoneNumber, pos + 1, prefix + c, res);
            }
        }
    }
}
