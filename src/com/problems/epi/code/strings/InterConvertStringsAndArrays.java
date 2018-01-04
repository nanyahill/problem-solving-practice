package com.problems.epi.code.strings;

/**
 * Problem Type: String Problem & Numerical Problem
 */
public class InterConvertStringsAndArrays {

    /**
     * Using brute force method to convert a string to an integer
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int parseIntBruteForce(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean isNegative = s.charAt(0) == '-';
        int res = 0;
        for(int i = (isNegative ? 1 : 0); i < len; i++) {
            int digit = s.charAt(i) - '0';
            res += digit * (Math.pow(10, len - i - 1));
        }
        return isNegative ? -res : res;
    }

    /**
     * Using a more efficient method to convert a string to an integer
     * Key Insight: Use a partial result to store already converted digits;
     * To convert a current digit to int based on its position:
     * Multiply the previous digit by 10 and add the current digit
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int parseInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        boolean isNegative = s.charAt(0) == '-';
        for(int i = (isNegative ? 1 : 0); i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
        }
        return isNegative ? (-res) : res;
    }

    /**
     * Using brute force method to convert an integer to a integer
     * Method: for any positive integer, the most significant digit is
     * x / 10 ^ (d - 1) where d is the no of digits
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static String toStringBruteForce(int num) {
        int numOfDigits = (int) Math.floor(Math.log10(num)) + 1;
        int cnt = numOfDigits - 1;
        StringBuilder res = new StringBuilder("");
        if(num < 0) res.append("-");
        while(cnt >= 0) {
            int mFactor = (int) Math.pow(10 , (cnt--));
            int digit = num / mFactor;
            num %= mFactor;
            res.append(digit);
        }
        return res.toString();
    }

    /**
     * Key Insight: For any positive integer x, the least significant digit in decimal is
     * x mod 10, and the remaining digits is x / 10
     * Time complexity: O(n)
     * Space Complexity: O(1)
     */
    public static String toString(int num) {
        StringBuilder res = new StringBuilder("");
        boolean isNegative = false;
        if(num < 0) isNegative = true;
        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            res.append(digit);
        }
        if(isNegative) res.append("-");
        return res.reverse().toString();
    }
}
