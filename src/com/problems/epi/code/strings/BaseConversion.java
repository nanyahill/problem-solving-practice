package com.problems.epi.code.strings;

/**
 * Problem Type: String Problem & Numerical Problem
 */
public class BaseConversion {

    /**
     * Using reduction pattern to break the problem into a simple one of
     * 1) Converting input string in base b1 to integer in base 10
     * 2) Converting the integer from step (1) into a string in b2
     */
    public static String convertBase(String str, int b1, int b2) {
        if (str == null || str.length() == 0) return "";
        boolean isNegative = str.charAt(0) == '-' ? true : false;

        // Convert from integer string in base b1 to integer in base 10
        int valueInBase10 = convertStringToIntBase10(str, b1);
        // Convert from integer in base 10 to String in base b2
        String result = convertIntInBase10ToString(valueInBase10, b2, isNegative);
        return result;
    }

    private static int convertStringToIntBase10(String str, int b1) {
        int result = 0;
        for (int i = (str.charAt(0) == '-' ? 1 : 0); i < str.length(); i++) {
            int digit = Character.isDigit(str.charAt(i)) ? str.charAt(i) - '0' : str.charAt(i) - 'A' + 10;
            result = result * b1 + digit; // similar to res = res * 10 + digit used in string to int conversion problem
        }
        return result;
    }

    private static String convertIntInBase10ToString(int value, int b2, boolean negativeFlag) {
        StringBuilder result = new StringBuilder();
        do {
            // Using Math.abs() for the case of -ve values
            int digit = Math.abs(value % b2);
            char c = (char) (digit >= 10 ? 'A' + digit - 10 : '0' + digit);
            value /= b2;
            result.append(c);
        } while (value != 0);
        if (negativeFlag == true) result.append('-');
        return result.reverse().toString();
    }
}
