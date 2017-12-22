package com.problems.epi.code.chapter4;

/**
 * Created by Nanya on 11/14/17.
 */
public class ReverseDigits {

    public static int reverseDigits(int num) {
        int result = 0;
        int prevResult = 0;
        int numRemaining = num;
        while (numRemaining != 0) {
            int digit = numRemaining % 10;
            numRemaining /= 10;
            result = (result * 10) + digit;
            if ((result - digit) / 10 != prevResult) {
                return 0;
            }
            prevResult = result;
        }
        return result;
    }

    public static int reverseDigitsWithString(int num) {
        String str = String.valueOf(num);
        char[] digits = str.toCharArray();
        for (int i = 0, j = digits.length - 1; i < j; i++, j--) {
            char tmp = digits[i];
            digits[i] = digits[j];
            digits[j] = tmp;
        }
        int result = Integer.parseInt(new String(digits));
        return num < 0 ? -result : result;
    }

    public static int reverseDigitsWithStringToo(int num) {
        String str = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return Integer.parseInt(builder.toString());
    }
}
