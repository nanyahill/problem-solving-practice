package com.problems.epi.code.strings;

import com.problems.epi.test.dynamic_programming.Scrap;

/**
 * Problem Type: String Problem & Numerical Problem
 */
public class InterConvertStringsAndArrays {


    /**
     * Key Insight: For any positive integer x, the least significant digit in decimal is
     * x mod 10, and the remaining digits is x / 10
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static String intToString(int num) {
        StringBuilder res = new StringBuilder("");
        boolean isNegative = false;
        if (num < 0) isNegative = true;
        // This is a case where do..while is important
        // If we just use while here then what if num = 0
        do {
            int digit = Math.abs(num % 10); // Math.abs(..) is important here because if num is -ve, the digit would always be a negative number.
            num /= 10;
            res.append(digit);
        } while (num != 0);
        if (isNegative) res.append("-"); // make sure to append the -ve sign before reversing
        return res.reverse().toString();
    }

    public static int stringToInt(String s) {
        int res = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
        }
        return s.charAt(0) == '-' ? -res : res;
    }
}
