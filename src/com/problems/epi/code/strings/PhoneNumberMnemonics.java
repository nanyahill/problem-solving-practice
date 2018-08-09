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

    public static List<String> phoneMnemonicIterative(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove().toUpperCase();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String nums = "798";
        phoneMnemonicIterative(nums);

    }

}
